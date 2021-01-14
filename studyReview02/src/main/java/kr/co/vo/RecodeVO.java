package kr.co.vo;

import java.sql.Date;

public class RecodeVO {
	
	private Integer user_idx;             //사용자번호
	private Date user_register_date;      //사용자 등록 날짜
	private String user_name;             //사용자 이름
	private String user_social_secunum;   //사용자 주민등록번호
	private String user_gender;           //사용자 성별
	private String user_comp;             //사용자 회사
	private Date user_comp_enterdate;     //사용자 입사일
	private String user_dept;             //사용자 부서
	private String user_spot;             //사용자 직위
	private String user_army_serv;        //사용자 병역
	private String user_marital_status;   //사용자 결혼
	private Date user_army_serv_enter;    //사용자 입대일
	private Date user_army_serv_leave;    //사용자 전역일
	private String user_army_serv_period; //사용자 역종/병과
	private String user_telnum_wired;     //사용자 유선전화
	private String user_telnum_wireless;  //사용자 휴대폰번호
	private String user_email;            //사용자 이메일
	private String user_zipcode;          //사용자 우편번호
	private String user_address;          //사용자 주소
	
	public RecodeVO() {}

	public Integer getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(Integer user_idx) {
		this.user_idx = user_idx;
	}

	public Date getUser_register_date() {
		return user_register_date;
	}

	public void setUser_register_date(Date user_register_date) {
		this.user_register_date = user_register_date;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_social_secunum() {
		return user_social_secunum;
	}

	public void setUser_social_secunum(String user_social_secunum) {
		this.user_social_secunum = user_social_secunum;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_comp() {
		return user_comp;
	}

	public void setUser_comp(String user_comp) {
		this.user_comp = user_comp;
	}

	public Date getUser_comp_enterdate() {
		return user_comp_enterdate;
	}

	public void setUser_comp_enterdate(Date user_comp_enterdate) {
		this.user_comp_enterdate = user_comp_enterdate;
	}

	public String getUser_dept() {
		return user_dept;
	}

	public void setUser_dept(String user_dept) {
		this.user_dept = user_dept;
	}

	public String getUser_spot() {
		return user_spot;
	}

	public void setUser_spot(String user_spot) {
		this.user_spot = user_spot;
	}

	public String getUser_army_serv() {
		return user_army_serv;
	}

	public void setUser_army_serv(String user_army_serv) {
		this.user_army_serv = user_army_serv;
	}

	public String getUser_marital_status() {
		return user_marital_status;
	}

	public void setUser_marital_status(String user_marital_status) {
		this.user_marital_status = user_marital_status;
	}

	public Date getUser_army_serv_enter() {
		return user_army_serv_enter;
	}

	public void setUser_army_serv_enter(Date user_army_serv_enter) {
		this.user_army_serv_enter = user_army_serv_enter;
	}

	public Date getUser_army_serv_leave() {
		return user_army_serv_leave;
	}

	public void setUser_army_serv_leave(Date user_army_serv_leave) {
		this.user_army_serv_leave = user_army_serv_leave;
	}

	public String getUser_army_serv_period() {
		return user_army_serv_period;
	}

	public void setUser_army_serv_period(String user_army_serv_period) {
		this.user_army_serv_period = user_army_serv_period;
	}

	public String getUser_telnum_wired() {
		return user_telnum_wired;
	}

	public void setUser_telnum_wired(String user_telnum_wired) {
		this.user_telnum_wired = user_telnum_wired;
	}

	public String getUser_telnum_wireless() {
		return user_telnum_wireless;
	}

	public void setUser_telnum_wireless(String user_telnum_wireless) {
		this.user_telnum_wireless = user_telnum_wireless;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_zipcode() {
		return user_zipcode;
	}

	public void setUser_zipcode(String user_zipcode) {
		this.user_zipcode = user_zipcode;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public RecodeVO(Integer user_idx, Date user_register_date, String user_name, String user_social_secunum,
			String user_gender, String user_comp, Date user_comp_enterdate, String user_dept, String user_spot,
			String user_army_serv, String user_marital_status, Date user_army_serv_enter, Date user_army_serv_leave,
			String user_army_serv_period, String user_telnum_wired, String user_telnum_wireless, String user_email,
			String user_zipcode, String user_address) {
		super();
		this.user_idx = user_idx;
		this.user_register_date = user_register_date;
		this.user_name = user_name;
		this.user_social_secunum = user_social_secunum;
		this.user_gender = user_gender;
		this.user_comp = user_comp;
		this.user_comp_enterdate = user_comp_enterdate;
		this.user_dept = user_dept;
		this.user_spot = user_spot;
		this.user_army_serv = user_army_serv;
		this.user_marital_status = user_marital_status;
		this.user_army_serv_enter = user_army_serv_enter;
		this.user_army_serv_leave = user_army_serv_leave;
		this.user_army_serv_period = user_army_serv_period;
		this.user_telnum_wired = user_telnum_wired;
		this.user_telnum_wireless = user_telnum_wireless;
		this.user_email = user_email;
		this.user_zipcode = user_zipcode;
		this.user_address = user_address;
	}

	@Override
	public String toString() {
		return "RecodeVO [user_idx=" + user_idx + ", user_register_date=" + user_register_date + ", user_name="
				+ user_name + ", user_social_secunum=" + user_social_secunum + ", user_gender=" + user_gender
				+ ", user_comp=" + user_comp + ", user_comp_enterdate=" + user_comp_enterdate + ", user_dept="
				+ user_dept + ", user_spot=" + user_spot + ", user_army_serv=" + user_army_serv
				+ ", user_marital_status=" + user_marital_status + ", user_army_serv_enter=" + user_army_serv_enter
				+ ", user_army_serv_leave=" + user_army_serv_leave + ", user_army_serv_period=" + user_army_serv_period
				+ ", user_telnum_wired=" + user_telnum_wired + ", user_telnum_wireless=" + user_telnum_wireless
				+ ", user_email=" + user_email + ", user_zipcode=" + user_zipcode + ", user_address=" + user_address
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_address == null) ? 0 : user_address.hashCode());
		result = prime * result + ((user_army_serv == null) ? 0 : user_army_serv.hashCode());
		result = prime * result + ((user_army_serv_enter == null) ? 0 : user_army_serv_enter.hashCode());
		result = prime * result + ((user_army_serv_leave == null) ? 0 : user_army_serv_leave.hashCode());
		result = prime * result + ((user_army_serv_period == null) ? 0 : user_army_serv_period.hashCode());
		result = prime * result + ((user_comp == null) ? 0 : user_comp.hashCode());
		result = prime * result + ((user_comp_enterdate == null) ? 0 : user_comp_enterdate.hashCode());
		result = prime * result + ((user_dept == null) ? 0 : user_dept.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_gender == null) ? 0 : user_gender.hashCode());
		result = prime * result + ((user_idx == null) ? 0 : user_idx.hashCode());
		result = prime * result + ((user_marital_status == null) ? 0 : user_marital_status.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_register_date == null) ? 0 : user_register_date.hashCode());
		result = prime * result + ((user_social_secunum == null) ? 0 : user_social_secunum.hashCode());
		result = prime * result + ((user_spot == null) ? 0 : user_spot.hashCode());
		result = prime * result + ((user_telnum_wired == null) ? 0 : user_telnum_wired.hashCode());
		result = prime * result + ((user_telnum_wireless == null) ? 0 : user_telnum_wireless.hashCode());
		result = prime * result + ((user_zipcode == null) ? 0 : user_zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecodeVO other = (RecodeVO) obj;
		if (user_address == null) {
			if (other.user_address != null)
				return false;
		} else if (!user_address.equals(other.user_address))
			return false;
		if (user_army_serv == null) {
			if (other.user_army_serv != null)
				return false;
		} else if (!user_army_serv.equals(other.user_army_serv))
			return false;
		if (user_army_serv_enter == null) {
			if (other.user_army_serv_enter != null)
				return false;
		} else if (!user_army_serv_enter.equals(other.user_army_serv_enter))
			return false;
		if (user_army_serv_leave == null) {
			if (other.user_army_serv_leave != null)
				return false;
		} else if (!user_army_serv_leave.equals(other.user_army_serv_leave))
			return false;
		if (user_army_serv_period == null) {
			if (other.user_army_serv_period != null)
				return false;
		} else if (!user_army_serv_period.equals(other.user_army_serv_period))
			return false;
		if (user_comp == null) {
			if (other.user_comp != null)
				return false;
		} else if (!user_comp.equals(other.user_comp))
			return false;
		if (user_comp_enterdate == null) {
			if (other.user_comp_enterdate != null)
				return false;
		} else if (!user_comp_enterdate.equals(other.user_comp_enterdate))
			return false;
		if (user_dept == null) {
			if (other.user_dept != null)
				return false;
		} else if (!user_dept.equals(other.user_dept))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_gender == null) {
			if (other.user_gender != null)
				return false;
		} else if (!user_gender.equals(other.user_gender))
			return false;
		if (user_idx == null) {
			if (other.user_idx != null)
				return false;
		} else if (!user_idx.equals(other.user_idx))
			return false;
		if (user_marital_status == null) {
			if (other.user_marital_status != null)
				return false;
		} else if (!user_marital_status.equals(other.user_marital_status))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_register_date == null) {
			if (other.user_register_date != null)
				return false;
		} else if (!user_register_date.equals(other.user_register_date))
			return false;
		if (user_social_secunum == null) {
			if (other.user_social_secunum != null)
				return false;
		} else if (!user_social_secunum.equals(other.user_social_secunum))
			return false;
		if (user_spot == null) {
			if (other.user_spot != null)
				return false;
		} else if (!user_spot.equals(other.user_spot))
			return false;
		if (user_telnum_wired == null) {
			if (other.user_telnum_wired != null)
				return false;
		} else if (!user_telnum_wired.equals(other.user_telnum_wired))
			return false;
		if (user_telnum_wireless == null) {
			if (other.user_telnum_wireless != null)
				return false;
		} else if (!user_telnum_wireless.equals(other.user_telnum_wireless))
			return false;
		if (user_zipcode == null) {
			if (other.user_zipcode != null)
				return false;
		} else if (!user_zipcode.equals(other.user_zipcode))
			return false;
		return true;
	}

}
