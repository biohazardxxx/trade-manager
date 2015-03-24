/* ===========================================================
 * TradeManager : a application to trade strategies for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Project Info:  org.trade
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Oracle, Inc.
 * in the United States and other countries.]
 *
 * (C) Copyright 2011-2011, by Simon Allen and Contributors.
 *
 * Original Author:  Simon Allen;
 * Contributor(s):   -;
 *
 * Changes
 * -------
 *
 */
package org.trade.persistent.dao;

// Generated Feb 21, 2011 2:18:03 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.trade.core.dao.Aspect;
import org.trade.core.util.CoreUtils;
import org.trade.core.util.TradingCalendar;

/**
 * Tradingday generated by hbm2java
 * 
 * @author Simon Allen
 * @version $Revision: 1.0 $
 */
@Entity
@Table(name = "tradingday")
public class Tradingday extends Aspect implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3388042483785305102L;

	@NotNull
	private Date open;
	@NotNull
	private Date close;
	private String marketBias;
	private String marketGap;
	private String marketBar;
	private List<Tradestrategy> tradestrategies = new ArrayList<Tradestrategy>(
			0);
	private List<Candle> candles = new ArrayList<Candle>(0);

	public Tradingday() {
	}

	/**
	 * Constructor for Tradingday.
	 * 
	 * @param open
	 *            Date
	 * @param close
	 *            Date
	 */
	public Tradingday(Date open, Date close) {
		this.open = open;
		this.close = close;
	}

	/**
	 * Constructor for Tradingday.
	 * 
	 * @param open
	 *            Date
	 * @param close
	 *            Date
	 * @param marketBias
	 *            String
	 * @param marketGap
	 *            String
	 * @param marketBar
	 *            String
	 * @param tradestrategies
	 *            List<Tradestrategy>
	 * @param candles
	 *            List<Candle>
	 */
	public Tradingday(Date open, Date close, String marketBias,
			String marketGap, String marketBar,
			List<Tradestrategy> tradestrategies, List<Candle> candles) {
		this.open = open;
		this.close = close;
		this.marketBias = marketBias;
		this.marketGap = marketGap;
		this.marketBar = marketBar;
		this.tradestrategies = tradestrategies;
		this.candles = candles;
	}

	/**
	 * Method getIdTradingDay.
	 * 
	 * @return Integer
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTradingDay", unique = true, nullable = false)
	public Integer getIdTradingDay() {
		return this.id;
	}

	/**
	 * Method setIdTradingDay.
	 * 
	 * @param idTradingDay
	 *            Integer
	 */
	public void setIdTradingDay(Integer idTradingDay) {
		this.id = idTradingDay;
	}

	/**
	 * Method getOpen.
	 * 
	 * @return Date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "open", unique = true, nullable = false, length = 19)
	public Date getOpen() {
		return this.open;
	}

	/**
	 * Method setOpen.
	 * 
	 * @param open
	 *            Date
	 */
	public void setOpen(Date open) {
		this.open = open;
	}

	/**
	 * Method getClose.
	 * 
	 * @return Date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "close", unique = true, nullable = false, length = 19)
	public Date getClose() {
		return this.close;
	}

	/**
	 * Method setClose.
	 * 
	 * @param close
	 *            Date
	 */
	public void setClose(Date close) {
		this.close = close;
	}

	/**
	 * Method getMarketBias.
	 * 
	 * @return String
	 */
	@Column(name = "marketBias", length = 10)
	public String getMarketBias() {
		return this.marketBias;
	}

	/**
	 * Method setMarketBias.
	 * 
	 * @param marketBias
	 *            String
	 */
	public void setMarketBias(String marketBias) {
		this.marketBias = marketBias;
	}

	/**
	 * Method getMarketGap.
	 * 
	 * @return String
	 */
	@Column(name = "marketGap", length = 10)
	public String getMarketGap() {
		return this.marketGap;
	}

	/**
	 * Method setMarketGap.
	 * 
	 * @param marketGap
	 *            String
	 */
	public void setMarketGap(String marketGap) {
		this.marketGap = marketGap;
	}

	/**
	 * Method getMarketBar.
	 * 
	 * @return String
	 */
	@Column(name = "marketBar", length = 10)
	public String getMarketBar() {
		return this.marketBar;
	}

	/**
	 * Method setMarketBar.
	 * 
	 * @param marketBar
	 *            String
	 */
	public void setMarketBar(String marketBar) {
		this.marketBar = marketBar;
	}

	/**
	 * Method getVersion.
	 * 
	 * @return Integer
	 */
	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Method setVersion.
	 * 
	 * @param version
	 *            Integer
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Method getTradestrategies.
	 * 
	 * @return List<Tradestrategy>
	 */
	@OneToMany(mappedBy = "tradingday", fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	@OrderBy("side ASC, idTradeStrategy ASC")
	public List<Tradestrategy> getTradestrategies() {
		return this.tradestrategies;
	}

	/**
	 * Method setTradestrategies.
	 * 
	 * @param tradestrategies
	 *            List<Tradestrategy>
	 */
	public void setTradestrategies(List<Tradestrategy> tradestrategies) {
		this.tradestrategies = tradestrategies;
	}

	/**
	 * Method addTradestrategy.
	 * 
	 * @param tradestrategy
	 *            Tradestrategy
	 */
	public void addTradestrategy(Tradestrategy tradestrategy) {
		this.tradestrategies.add(tradestrategy);
	}

	/**
	 * Method removeTradestrategies.
	 * 
	 * @param tradestrategy
	 *            Tradestrategy
	 */
	public boolean removeTradestrategy(Tradestrategy tradestrategy) {
		for (ListIterator<Tradestrategy> itemIter = this.tradestrategies
				.listIterator(); itemIter.hasNext();) {
			Tradestrategy item = itemIter.next();
			if (item.equals(tradestrategy)) {
				itemIter.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Method getCandles.
	 * 
	 * @return List<Candle>
	 */
	@OneToMany(mappedBy = "tradingday", fetch = FetchType.LAZY)
	public List<Candle> getCandles() {
		return this.candles;
	}

	/**
	 * Method setCandles.
	 * 
	 * @param candles
	 *            List<Candle>
	 */
	public void setCandles(List<Candle> candles) {
		this.candles = candles;
	}

	/**
	 * Method addCandle.
	 * 
	 * @param candle
	 *            Candle
	 */
	public void addCandle(Candle candle) {
		this.candles.add(candle);
	}

	public static final Comparator<Tradingday> DATE_ORDER_ASC = new Comparator<Tradingday>() {
		public int compare(Tradingday o1, Tradingday o2) {
			int returnVal = 0;
			m_ascending = true;
			returnVal = CoreUtils
					.nullSafeComparator(o1.getOpen(), o2.getOpen());
			if (m_ascending.equals(Boolean.FALSE)) {
				returnVal = returnVal * -1;
			}
			return returnVal;
		}
	};

	public static final Comparator<Tradingday> DATE_ORDER_DESC = new Comparator<Tradingday>() {
		public int compare(Tradingday o1, Tradingday o2) {
			int returnVal = 0;
			m_ascending = false;
			returnVal = CoreUtils
					.nullSafeComparator(o1.getOpen(), o2.getOpen());
			if (m_ascending.equals(Boolean.FALSE)) {
				returnVal = returnVal * -1;
			}
			return returnVal;
		}
	};

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	public String toString() {
		return TradingCalendar.getFormattedDate(getOpen(), "MM/dd/yyyy");
	}

	/**
	 * Method hashCode.
	 * 
	 * For every field tested in the equals-Method, calculate a hash code c by:
	 * 
	 * If the field f is a boolean: calculate * (f ? 0 : 1);
	 * 
	 * If the field f is a byte, char, short or int: calculate (int)f;
	 * 
	 * If the field f is a long: calculate (int)(f ^ (f >>> 32));
	 * 
	 * If the field f is a float: calculate Float.floatToIntBits(f);
	 * 
	 * If the field f is a double: calculate Double.doubleToLongBits(f) and
	 * handle the return value like every long value;
	 * 
	 * If the field f is an object: Use the result of the hashCode() method or 0
	 * if f == null;
	 * 
	 * If the field f is an array: See every field as separate element and
	 * calculate the hash value in a recursive fashion and combine the values as
	 * described next.
	 * 
	 * @return int
	 */
	public int hashCode() {
		int hash = super.hashCode();
		hash = hash + (this.getOpen() == null ? 0 : this.getOpen().hashCode());
		hash = hash
				+ (this.getClose() == null ? 0 : this.getClose().hashCode());
		return hash;
	}

	/**
	 * Method equals.
	 * 
	 * @param objectToCompare
	 *            Object
	 * @return boolean
	 */
	public boolean equals(Object objectToCompare) {

		if (super.equals(objectToCompare))
			return true;

		if (objectToCompare instanceof Tradingday) {
			Tradingday tradingday = (Tradingday) objectToCompare;
			if (tradingday.getOpen().compareTo(this.getOpen()) == 0) {
				if (tradingday.getClose().compareTo(this.getClose()) == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method newInstance.
	 * 
	 * @param date
	 *            Date
	 * @return Tradingday
	 */
	public static Tradingday newInstance(Date date) {
		Tradingday tradingday = new Tradingday(
				TradingCalendar.getBusinessDayStart(date),
				TradingCalendar.getBusinessDayEnd(date));
		return tradingday;

	}

	/**
	 * Method existTradestrategy.
	 * 
	 * @param tradestrategy
	 *            Tradestrategy
	 * @return boolean
	 */
	public boolean existTradestrategy(Tradestrategy tradestrategy) {
		if (null != this.getTradestrategies()) {
			for (Tradestrategy currTradestrategy : this.getTradestrategies()) {
				if (currTradestrategy.equals(tradestrategy)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Method populateStrategyData.
	 * 
	 * @param tradingday
	 *            Tradingday
	 */
	public void populateStrategyData(Tradingday tradingday) {
		if (null != tradingday.getTradestrategies()) {
			for (Tradestrategy currTradestrategy : tradingday
					.getTradestrategies()) {
				for (Tradestrategy tradestrategy : this.getTradestrategies()) {
					if (currTradestrategy.equals(tradestrategy)) {
						tradestrategy.setStrategyData(currTradestrategy
								.getStrategyData());
						break;
					}
				}
			}
		}
	}

	/**
	 * Method isDirty.
	 * 
	 * @return boolean
	 */
	@Transient
	public boolean isDirty() {
		for (Tradestrategy item : this.getTradestrategies()) {
			if (item.isDirty())
				return true;
		}
		return super.isDirty();
	}

	/**
	 * Method clone.
	 * 
	 * @return Object
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException {

		Tradingday tradingday = (Tradingday) super.clone();
		List<Tradestrategy> tradestrategies = new ArrayList<Tradestrategy>(0);
		tradingday.setTradestrategies(tradestrategies);
		List<Candle> candles = new ArrayList<Candle>(0);
		tradingday.setCandles(candles);
		return tradingday;
	}

	public void clear() {
		getTradestrategies().clear();
	}
}
