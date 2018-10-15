package com.datastructure.array;

/**
 * 1、数组中插入、删除、查询
 * 2、数组是int类型
 *
 * Created by lx on 2018/10/12.
 */
public class Array {

    // 定义整型datas数组
    public int datas[];
    // 定义数组中保存数据个数
    private int count;

    public Array(int initLength) {
        this.datas = new int[]{0,1,2,3,4};
        this.count = initLength;
    }

    /**
     * 根据索引查询数组中的元素并返回
     * @param index 索引
     * @return 查询元素
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return this.datas[index];
    }

    /**
     * 根据索引，向数组中插入元素
     * @param index 索引值
     * @param value 插入的数据
     * @return
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > count) {
            return false;
        }
        int[] arr = new int[count+1];
        for (int i = 0; i < count; ++i) {
            arr[i] = datas[i];
        }
        datas = arr;
        if (index == count) {
            // 向数组末尾插入元素，时间复杂度为O(1)
            this.datas[index] = value;
        }else {
            // 向数组内部插入元素，时间复杂度为O(n)
            for (int i = count - 1;i >= index;--i) {
                this.datas[i+1] = this.datas[i];
            }
            this.datas[index] = value;
        }
        ++count;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     * @param index 索引值
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index + 1;i < count;++i) {
            this.datas[i-1] = this.datas[i];
        }
        --count;
        return true;
    }

    public void print() {
        for (int i = 0;i < count;++i) {
            System.out.print(datas[i] + " ");
        }
        System.out.println();
    }

}
