package cw.learn.houserent.service;

import cw.learn.houserent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums;

    public HouseService(int size) {
        // 指定House数组大小
        this.houses = new House[size];
        houses[0] = new House(1, "cw", "110", "万吉苑", 2000, "未出租");
        this.houseNums = 1;
    }

    public House[] list(){
        return houses;
    }

    public boolean add(House newHouse){
//        暂时不考虑数组扩容
        if(houseNums >= houses.length){
            System.out.println("房屋已满，不能添加");
            return false;
        }
        houses[houseNums++] = newHouse;
//        更新id
        newHouse.setId(houseNums);
        return true;
    }

    public boolean del(int delId){
        int index = -1;
        for(int i = 0; i < houseNums; i++){
            if(delId == houses[i].getId()){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("未找到该房屋");
            return false;
        }
        for(int i = index; i < houseNums - 1; i++){
            houses[i] = houses[i+1];
            houses[i].setId(houses[i].getId() - 1);
        }
//        前后--的妙用
        houses[--houseNums] = null;
        return true;
    }

    public House findById(int findId){
        for(int i = 0; i < houseNums; i++){
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }
}
