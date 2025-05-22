package com.mjc813.mjc_library;

import lombok.Getter;
import lombok.Setter;

/**
 * MJC 포인트를 처리하는 클래스, 초기값은 100 포인트
 */
@Getter
@Setter
public class MjcPoint {
    /**
     * 포인트 점수
     */
    private int marketPoint = 100;

    /**
     * MJC 포인트에 point 점수만큼 더합니다.
     * 각 가맹점 상점의 광고를 getMessageOfMarketInfo 문자열로 출력하고 현재 포인트를 출력합니다.
     * @param info IMarketInfo 구현 클래스
     * @param point 포인트 점수는 1~50까지 가능, 부정확한 값일경우에는 getMessageOfNotValidData 문자열을 출력합니다.
     * @return
     */
    public int addPoint(IMarketInfo info, int point) {
        if (info == null) {
            System.out.println("addPoint(info, point) 호출 시에 info 가 null 이므로 실패했습니다.");
            return this.marketPoint;
        }
        if ( point >= 1 && point <= 50 ) {
            this.marketPoint += point;
            System.out.println(info.getMessageOfMarketInfo());
            System.out.printf("매장의 현재 포인트는 [%d] 입니다.\n", this.marketPoint);
        } else {
            System.out.println(info.getMessageOfNotValidData());
        }
        return this.marketPoint;
    }

    /**
     * MJC 포인트에 point 점수만큼 뺍니다.
     * 각 가맹점 상점의 광고를 getMessageOfMarketInfo 문자열로 출력하고 현재 포인트를 출력합니다.
     * @param info IMarketInfo 구현 클래스
     * @param point 포인트 점수는 1~20까지 가능, 부정확한 값일경우에는 getMessageOfNotValidData 문자열을 출력합니다.
     * @return
     */
    public int subPoint(IMarketInfo info, int point) {
        if (info == null) {
            System.out.println("addPoint(info, point) 호출 시에 info 가 null 이므로 실패했습니다.");
            return this.marketPoint;
        }
        if ( point >= 1 && point <= 20 ) {
            this.marketPoint -= point;
            System.out.println(info.getMessageOfMarketInfo());
            System.out.printf("매장의 현재 포인트는 [%d] 입니다.\n", this.marketPoint);
        } else {
            System.out.println(info.getMessageOfNotValidData());
        }
        return this.marketPoint;
    }
}
