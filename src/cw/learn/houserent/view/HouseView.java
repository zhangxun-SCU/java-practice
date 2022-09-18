package cw.learn.houserent.view;

import cw.learn.houserent.domain.House;
import cw.learn.houserent.service.HouseService;
import cw.learn.houserent.utils.Utility;

/**
 * 1. 显示界面
 * 2. 接收用户输入
 * 3. 调用HouseService
 */
public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    //    显示主菜单
    public void mainMenu() {
        do {
            System.out.println("\n----------房屋出租系统----------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出系统");
            System.out.print("请输入你的选择：");
            key = Utility.readChar();
            switch (key) {
                case '1' -> {
                    this.addHouse();
                }
                case '2' -> {
                    this.findHouse();
                }
                case '3' -> {
                    this.delHouse();
                }
                case '4' -> {
                    System.out.println("\t\t4 修改房屋信息");
                }
                case '5' -> {
                    this.listHouses();
                }
                case '6' -> {
                    exit();
                }
                default -> {
                    System.out.println("选择有误，重新选择");
                }
            }
        } while (loop);
    }

    //    添加房屋
    public void addHouse() {
        System.out.println("----------添加房屋----------");
        System.out.print("房主姓名：");
        String name = Utility.readString(8);
        System.out.print("房主电话：");
        String phone = Utility.readString(12);
        System.out.print("房屋地址：");
        String address = Utility.readString(20);
        System.out.print("月租价格：");
        int rent = Utility.readInt();
        System.out.print("当前状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);

        if (houseService.add(newHouse)) {
            System.out.println("----------添加成功----------");
        } else {
            System.out.println("----------添加失败----------");
        }
    }

    // 删除
    public void delHouse() {
        System.out.println("----------删除房屋----------");
        System.out.print("输入待删除房屋的编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("----------取消删除----------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("----------删除成功----------");
            } else {
                System.out.println("----------删除失败----------");
            }
        } else {
            System.out.println("----------取消删除----------");
        }
    }

    //    显示房屋列表
    public void listHouses() {
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        // 得到房屋数组
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("----------房屋列表----------");
    }

    public void findHouse() {
        System.out.println("----------查找房屋信息----------");
        System.out.print("输入房屋的编号(-1退出)：");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("取消修改");
            return;
        }
        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("此房屋不存在！");
        }
    }

    public void updateHouse() {
        System.out.println("----------根据id修改房屋信息----------");
        System.out.print("输入房屋的编号(-1退出)：");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("取消修改");
            return;
        }
        House house = houseService.findById(findId);
        if (house == null) {
            System.out.println("此房屋不存在");
            return;
        }
        System.out.print("姓名(" + house.getName() + ")：");
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }

        System.out.print("地址(" + house.getAddress() + ")：");
        String address = Utility.readString(20, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }

        System.out.print("月租(" + house.getRent() + ")：");
        int rent = Utility.readInt(0);
        if (!(rent == 0)) {
            house.setRent(rent);
        }

        System.out.print("当前状态(" + house.getAddress() + ")：");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
    }

    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
            System.out.println("退出系统");
        }
    }
}
