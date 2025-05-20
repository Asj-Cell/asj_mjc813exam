package com.mjc.studyjava;

public class Mouse {
    private int pointX;
    private int pointY;

    public void clickLeftButton(int x,int y) {
        moveMouse(x, y);
        System.out.printf("마우스(%d, %d) 왼쪽버튼 클릭됨\n",pointX,pointY);
    }
    public void clickRightButton(int x,int y) {
        moveMouse(x, y);
        System.out.printf("마우스(%d, %d) 오른쪽버튼 클릭됨\n",pointX,pointY);
    }
    public void moveMouse(int x, int y) {
        this.pointX= x;
        this.pointY= y;
    }

}
