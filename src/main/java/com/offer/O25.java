package com.offer;

import java.util.HashMap;

/**
 * 题目描述
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class O25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 条件：额外的HashMap 存储原链表的元素和与之对应的新链表的元素
     * 分两步：
     *  1.先直接复制原链表的next顺序，每复制一个就将被复制的和复制的放入map中
     *  2.复制完后处理random,遍历原链表的每个元素在map中找到器random对象，
     *      也就找到复制链表的对应元素的random
     *
     *  时间复杂度和空间复杂度都是O(N)
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = new RandomListNode(pHead.label);
        RandomListNode cur = dummy.next;
        RandomListNode old = pHead;

        //存放原链表的元素和对应的新链表的元素
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(old, cur);


        while (old.next != null) {
            old = old.next;
            cur.next = new RandomListNode(old.label);
            cur = cur.next;
            map.put(old, cur);
        }

        old = pHead;
        while (old != null) {
            RandomListNode random = old.random;
            map.get(old).random = map.containsKey(random) ? map.get(random) : null;
            old = old.next;
        }

        return dummy.next;
    }

    /**
     * 不借助额外的空间
     * 分三步
     *      1.复制链表节点，但是将其连接到其原体的后面
     *      2.处理random ,依次处理链表的random,原链表的元素的random 的next就是复制链表的random
     *      3.分离复合链表：包偶数位上的链表分离连接起来就是复制的要求链表
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode old = pHead;
        //1.复制链表节点，但是将复制的新节点连接到其原体next
        while (old!=null){
            RandomListNode next = old.next;
            old.next = new RandomListNode(old.label);
            old.next.next = next;
            old=next;
        }

        //2.依次处理链表的random,原链表的元素的random 的next就是复制链表的random
        old = pHead;
        while (old!=null){
            RandomListNode random = old.random;
            if (random!=null){
                old.next.random = random.next;
            }
            old = old.next.next;
        }

        //3.分离复合链表：将偶数位上的链表分离连接起来就是复制的要求链表
        old =pHead;
        RandomListNode pClone=pHead.next;
        while (old!=null){
            RandomListNode clone = old.next; //复制的节点
            old.next = clone.next;
            clone.next = clone.next==null?null:clone.next.next;
            old = old.next;
        }
        return pClone;
    }


    public static void main(String[] args) {
        HashMap<O25, Integer> map = new HashMap<>();
        O25 o = new O25();
        map.put(o, 1);
        o = new O25();
        map.put(o, 2);
        System.out.println(map.size());

    }

}
