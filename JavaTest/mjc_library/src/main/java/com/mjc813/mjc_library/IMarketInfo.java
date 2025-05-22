package com.mjc813.mjc_library;

/**
 * 본인 상점과 에러에 대한 문자열을 리턴하는 클래스
 * 예를 들어 SampleMarketInfo 클래스를 참고하여 코딩하세요.
 */
public interface IMarketInfo {
    /**
     * 자신의 상점에 대한 광고성 설명을 문자열로 리턴해주세요.
     * 예를 들면 return "홍길동 반점입니다. T.02)1111-2222"
     * @return
     */
    String getMessageOfMarketInfo();

    /**
     * 정확하지 않은 값으로 호출시 에러 메세지 문자열을 리턴해 주세요.
     * 예를 들면 return "부정확한 값입니다."
     * @return
     */
    String getMessageOfNotValidData();
}
