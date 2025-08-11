package com.mjc813.food_web.ingredient_category.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/ingredient_category")
public class IngredientCategoryRestController extends CommonRestController {
    @Autowired
    private IngredientCategoryService IngredientCategoryService;

    /**
     * 재료 카테고리 검색 (이름으로 필터링, 페이징 및 정렬 포함).
     *
     * @param name 검색할 카테고리 이름
     * @param pageable 페이징 및 정렬 정보 (기본값: size=10, sort=id, direction=DESC)
     * @return 검색 결과를 담은 응답 엔티티 (Page<IngredientCategoryEntity>)
     */
    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("name") String name,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<IngredientCategoryEntity> all = this.IngredientCategoryService.findByNameContainsRepository(name, pageable);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    /**
     * 새로운 재료 카테고리를 삽입합니다.
     *
     * @param dto 삽입할 재료 카테고리 데이터
     * @return 삽입 결과를 담은 응답 엔티티
     */
    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody IngredientCategoryDto dto
    ) {
        try {
            IIdName iIdName = this.IngredientCategoryService.insertRepository(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    /**
     * 특정 ID를 가진 재료 카테고리를 업데이트합니다.
     *
     * @param id 업데이트할 재료 카테고리의 ID
     * @param dto 업데이트할 데이터
     * @return 업데이트 결과를 담은 응답 엔티티
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody IngredientCategoryDto dto
    ) {
        try {
            IIdName iIdName = this.IngredientCategoryService.updateRepository(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.UPDATE_FAIL, "Error", dto, th);
        }
    }

    /**
     * 특정 ID를 가진 재료 카테고리를 삭제합니다.
     *
     * @param id 삭제할 재료 카테고리의 ID
     * @return 삭제 결과를 담은 응답 엔티티
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(
            @PathVariable Long id
    ) {
        try {
            Boolean bResult = this.IngredientCategoryService.deleteRepository(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", bResult, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    /**
     * 특정 ID를 가진 재료 카테고리를 조회합니다.
     *
     * @param id 조회할 재료 카테고리의 ID
     * @return 조회 결과를 담은 응답 엔티티
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IIdName find = this.IngredientCategoryService.findByIdRepository(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    /**
     * 모든 재료 카테고리를 조회합니다.
     *
     * @return 모든 카테고리 목록을 담은 응답 엔티티
     */
    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<IIdName> all = this.IngredientCategoryService.findAllRepository();
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }
}