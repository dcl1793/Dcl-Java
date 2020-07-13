package hs.dcl.test.enums;

/**
 * @author dacl30868
 * @date   2020年6月23日下午7:46:07
 */
public interface StatusConstant {

	  String status();
    
	  String desc();

	//证件类型
	enum CRETYPE implements  StatusConstant {

		//居民状态
		CRETYPE_0("0","身份证"),
		CRETYPE_1("1","护照"),
		CRETYPE_2("2","港澳通行证"),
		CRETYPE_3("3","其他");


		private final String status;

		private final String desc;

		CRETYPE(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			CRETYPE[] businessModeEnums = values();
			for (CRETYPE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			CRETYPE[] businessModeEnums = values();
			for (CRETYPE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//居民状态
	enum RESIDENT implements  StatusConstant {
		
		//居民状态
        LOCAL("0","本地"),
        NON_LOCAL("1","非本地");
		
		private final String status;
	    
		private final String desc;  
	      
	    RESIDENT(final String status, final String desc){
	        this.status = status;  
	        this.desc = desc;  
	    }  
	      
	    public static String getValue(String value) {
			RESIDENT[] businessModeEnums = values();
	        for (RESIDENT businessModeEnum : businessModeEnums) {
	            if (businessModeEnum.desc().equals(value)) {
	                return businessModeEnum.status();  
	            }  
	        }  
	        return null;  
	    }   
	      
	    public static String getDesc(String value) {
			RESIDENT[] businessModeEnums = values();
	        for (RESIDENT businessModeEnum : businessModeEnums) {
	            if (businessModeEnum.status().equals(value)) {
	                return businessModeEnum.desc();  
	            }  
	        }  
	        return null;  
	    }  
	      
	    public String status(){  
	        return this.status;  
	    }  
	      
	    public String desc(){  
	        return this.desc;  
	    }  
	}

	//账户状态
	enum ACCOUNT implements  StatusConstant {

		//账户状态
		ACCOUNT_NO("0","在职"),
		ACCOUNT_YES("1","离职");


		private final String status;

		private final String desc;

		ACCOUNT(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			ACCOUNT[] businessModeEnums = values();
			for (ACCOUNT businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			ACCOUNT[] businessModeEnums = values();
			for (ACCOUNT businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//员工属性
	enum EMPLO implements  StatusConstant {

		//员工属性
		EMPLO_0("0","员工"),
		EMPLO_1("1","高管"),
		EMPLO_2("2","大股东"),
		EMPLO_3("3","行动一致人");

		private final String status;

		private final String desc;

		EMPLO(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			EMPLO[] businessModeEnums = values();
			for (EMPLO businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			EMPLO[] businessModeEnums = values();
			for (EMPLO businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//审核状态
	enum AUDIT implements  StatusConstant {

		//审核状态
		AUDIT_NO("0","待审核"),
		AUDIT_YES("1","通过");

		private final String status;

		private final String desc;

		AUDIT(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			AUDIT[] businessModeEnums = values();
			for (AUDIT businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			AUDIT[] businessModeEnums = values();
			for (AUDIT businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//联通标志
	enum ONLING implements  StatusConstant {

		//联通标志
		ONLING_NO("0","否"),
		ONLING_YES("1","是");

		private final String status;

		private final String desc;

		ONLING(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			ONLING[] businessModeEnums = values();
			for (ONLING businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			ONLING[] businessModeEnums = values();
			for (ONLING businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//禁止托管
	enum RETRU implements  StatusConstant {

		//禁止托管
		RETRU_NO("0","否"),
		RETRU_YES("1","是");

		private final String status;

		private final String desc;

		RETRU(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			RETRU[] businessModeEnums = values();
			for (RETRU businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			RETRU[] businessModeEnums = values();
			for (RETRU businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//禁止撤销指定
	enum REVOKE implements  StatusConstant {

		//禁止撤销指定
		REVOKE_NO("0","否"),
		REVOKE_YES("1","是");

		private final String status;

		private final String desc;

		REVOKE(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			REVOKE[] businessModeEnums = values();
			for (REVOKE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			REVOKE[] businessModeEnums = values();
			for (REVOKE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//禁止变更三方存管
	enum CHANGE implements  StatusConstant {

		//禁止变更三方存管
		CHANGE_NO("0","否"),
		CHANGE_YES("1","是");

		private final String status;

		private final String desc;

		CHANGE(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			CHANGE[] businessModeEnums = values();
			for (CHANGE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			CHANGE[] businessModeEnums = values();
			for (CHANGE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//禁止交易标的外证券
	enum DEAL implements  StatusConstant {

		//禁止交易标的外证券
		DEAL_NO("0","否"),
		DEAL_YES("1","是");

		private final String status;

		private final String desc;

		DEAL(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			DEAL[] businessModeEnums = values();
			for (DEAL businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			DEAL[] businessModeEnums = values();
			for (DEAL businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//计划类型
	enum PLANTYPE implements  StatusConstant {

		//计划类型
		PLANTYPE_0("0","股票期权"),
		PLANTYPE_1("1","限制性股票");

		private final String status;

		private final String desc;

		PLANTYPE(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			PLANTYPE[] businessModeEnums = values();
			for (PLANTYPE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			PLANTYPE[] businessModeEnums = values();
			for (PLANTYPE businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}

	//部门
	enum BRANCH implements  StatusConstant {

		//部门
		BRANCH_0("0","市场部"),
		BRANCH_1("1","研发部"),
		BRANCH_2("2","信息部"),
		BRANCH_3("3","公关部");

		private final String status;

		private final String desc;

		BRANCH(final String status, final String desc){
			this.status = status;
			this.desc = desc;
		}

		public static String getValue(String value) {
			BRANCH[] businessModeEnums = values();
			for (BRANCH businessModeEnum : businessModeEnums) {
				if (businessModeEnum.desc().equals(value)) {
					return businessModeEnum.status();
				}
			}
			return null;
		}

		public static String getDesc(String value) {
			BRANCH[] businessModeEnums = values();
			for (BRANCH businessModeEnum : businessModeEnums) {
				if (businessModeEnum.status().equals(value)) {
					return businessModeEnum.desc();
				}
			}
			return null;
		}

		public String status(){
			return this.status;
		}

		public String desc(){
			return this.desc;
		}
	}
}
