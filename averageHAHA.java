/**
 * 几人出行， 花费甚多， 故AA之
 * 又，行程繁忙， 有人先付， 有人未付
 * 行程完了，于是均摊流向
 * 他予你多少  我收他多少
 * 皆由此算法得出一二
 * 凡算法者，必有漏洞
 * 还望精通数据结构之人
 * 指点一二
 * 此生感激不尽。
 *        - 2016/09/19 夜·雨 Xi'an
 * 
 */
package com.carfun.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * AA制，算法演练
 * 
 * @author KZoneFind
 *
 */
public class averageHAHA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> givenMap = new HashMap<String, String>();

    // 第二个参数暂时不使用， 故置为0
		Man aMan = new Man("A", 0, 10);
		Man bMan = new Man("B", 0, 1);
		Man cMan = new Man("C", 0, -2);
		Man dMan = new Man("D", 0, -3);
		Man eMan = new Man("E", 0, -6);

		List<Man> lstMan = new ArrayList<averageHAHA.Man>();
		lstMan.add(aMan);
		lstMan.add(bMan);
		lstMan.add(dMan);
		lstMan.add(cMan);
		lstMan.add(eMan);

		int count = 0;
		do {
			String getPath = "";
			int getMoney = 0;
			// 最大的  收 最小的
			count = lstMan.get(0).finalPay + lstMan.get(lstMan.size() - 1).finalPay;
			// 得到给予 【路径】 
			getPath = lstMan.get(0).name + " get from " + lstMan.get(lstMan.size() - 1).name;
			
			if (count > 0) {
				// 得到给予 【多少】
				getMoney = - lstMan.get(lstMan.size() - 1).finalPay;
				// 重计算花费
				lstMan.get(0).finalPay = count;
				// 调整list
				lstMan.remove(lstMan.size() - 1);
			} else if (count == 0){
				getMoney = lstMan.get(0).finalPay;
				lstMan.remove(0);
				lstMan.remove(lstMan.size() - 1);
			} else {
				getMoney = lstMan.get(0).finalPay;
				lstMan.get(lstMan.size() - 1).finalPay = count;
				lstMan.remove(0);
			}
			
			givenMap.put(getPath, "" + getMoney);
		} while (lstMan.size() != 0);
		
		// 打印
		Set<String> set = givenMap.keySet();
		Iterator<String> iter =  set.iterator();
		while (iter.hasNext()){
			String key = iter.next();
			System.out.println( key + ": " + givenMap.get(key));
		};

	}

	public static class Man {
		public Man(String name, int payMoney, int finalPay) {
			this.name = name;
			this.payMoney = payMoney;
			this.finalPay = finalPay;
		}

		// 名字
		private String name;
		// 总花费
		private int payMoney;
		// 实际花费(与平均值相差)
		private int finalPay;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPayMoney() {
			return payMoney;
		}

		public void setPayMoney(int payMoney) {
			this.payMoney = payMoney;
		}

		public int getFinalPay() {
			return finalPay;
		}

		public void setFinalPay(int finalPay) {
			this.finalPay = finalPay;
		}
	}

}
