package com.snk.common.constant;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ProConstants {
    /**
     * 车位状态
     * 1：待出售 2：已出售 3：待出租 4：已出租 5:临时车位
     */
    public static Long CARPORT_STATE_SALEING=1L;
    public static Long CARPORT_STATE_SALED=2L;
    public static Long CARPORT_STATE_RENTING=3L;
    public static Long CARPORT_STATE_RENTED=4L;
    public static Long CARPORT_STATE_TEMPORARY=5L;

    /**
     * 停车属性
     * 1：有车位
     * 2：小区业主无车位
     * 3：车位数，小于车辆数
     * 4：非小区业主、无车位
     */
    public static Long HOUSE_CAR_HAVE=1L;
    public static Long HOUSE_CAR_NO_HAVE=2L;
    public static Long HOUSE_CAR_LESS=3L;
    public static Long HOUSE_CAR_MORE=4L;

    /**
     * 0：未出售
     * 1：出售未装修
     * 2：装修已入住
     */
    public static Long HOUSE_SALEING=0L;
    public static Long HOUSE_SALED_BUT_COMPLETE=1L;
    public static Long HOUSE_SALED_AND_COMPLETE=2L;

    /**
     * 车辆属性ID
     *4：非小区业主、无车位
     */
    public static Long PRO_STOP_CAR_ATTRIBUTE_ID=4L;

    public static Double STOP_CAR_TIME=60*60*1000d;//一小时

    /**
     * 维修状态
     * 1：待处理 2：待维修 3：已完成
     */
    public static Long REPAIR_STATE_NO=1L;
    public static Long REPAIR_STATE_ING=2L;
    public static Long REPAIR_STATE_ED=3L;


    /**
     * 物业费审核
     * 0：未审核
     * 1：审核通过
     * 2：未通过
     */

    public static Long HOUSE_ORDER_REVIEW_ING=0L;
    public static Long HOUSE_ORDER_REVIEW_YES=1L;
    public static Long HOUSE_ORDER_REVIEW_NO=2L;

    /**
     * 物业费上架
     * 0:下架
     * 1：上架
     */
    public static Long HOUSE_ORDER_SHELF_NO=0L;
    public static Long HOUSE_ORDER_SHELF_YES=1L;






}
