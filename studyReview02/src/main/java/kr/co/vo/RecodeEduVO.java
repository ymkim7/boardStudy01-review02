package kr.co.vo;

public class RecodeEduVO {
	
	private Integer edu_idx;        //학교번호
	private Integer user_idx;       //사용자번호
	private String edu_school_nane; //학교명
	private String edu_status;      //학교상태
	private String edu_year;        //학교졸업년도
	private String edu_month;       //학교졸업월

	public RecodeEduVO() {}

	public Integer getEdu_idx() {
		return edu_idx;
	}

	public void setEdu_idx(Integer edu_idx) {
		this.edu_idx = edu_idx;
	}

	public Integer getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(Integer user_idx) {
		this.user_idx = user_idx;
	}

	public String getEdu_school_nane() {
		return edu_school_nane;
	}

	public void setEdu_school_nane(String edu_school_nane) {
		this.edu_school_nane = edu_school_nane;
	}

	public String getEdu_status() {
		return edu_status;
	}

	public void setEdu_status(String edu_status) {
		this.edu_status = edu_status;
	}

	public String getEdu_year() {
		return edu_year;
	}

	public void setEdu_year(String edu_year) {
		this.edu_year = edu_year;
	}

	public String getEdu_month() {
		return edu_month;
	}

	public void setEdu_month(String edu_month) {
		this.edu_month = edu_month;
	}

	public RecodeEduVO(Integer edu_idx, Integer user_idx, String edu_school_nane, String edu_status, String edu_year,
			String edu_month) {
		super();
		this.edu_idx = edu_idx;
		this.user_idx = user_idx;
		this.edu_school_nane = edu_school_nane;
		this.edu_status = edu_status;
		this.edu_year = edu_year;
		this.edu_month = edu_month;
	}

	@Override
	public String toString() {
		return "RecodeEduVO [edu_idx=" + edu_idx + ", user_idx=" + user_idx + ", edu_school_nane=" + edu_school_nane
				+ ", edu_status=" + edu_status + ", edu_year=" + edu_year + ", edu_month=" + edu_month + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edu_idx == null) ? 0 : edu_idx.hashCode());
		result = prime * result + ((edu_month == null) ? 0 : edu_month.hashCode());
		result = prime * result + ((edu_school_nane == null) ? 0 : edu_school_nane.hashCode());
		result = prime * result + ((edu_status == null) ? 0 : edu_status.hashCode());
		result = prime * result + ((edu_year == null) ? 0 : edu_year.hashCode());
		result = prime * result + ((user_idx == null) ? 0 : user_idx.hashCode());
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
		RecodeEduVO other = (RecodeEduVO) obj;
		if (edu_idx == null) {
			if (other.edu_idx != null)
				return false;
		} else if (!edu_idx.equals(other.edu_idx))
			return false;
		if (edu_month == null) {
			if (other.edu_month != null)
				return false;
		} else if (!edu_month.equals(other.edu_month))
			return false;
		if (edu_school_nane == null) {
			if (other.edu_school_nane != null)
				return false;
		} else if (!edu_school_nane.equals(other.edu_school_nane))
			return false;
		if (edu_status == null) {
			if (other.edu_status != null)
				return false;
		} else if (!edu_status.equals(other.edu_status))
			return false;
		if (edu_year == null) {
			if (other.edu_year != null)
				return false;
		} else if (!edu_year.equals(other.edu_year))
			return false;
		if (user_idx == null) {
			if (other.user_idx != null)
				return false;
		} else if (!user_idx.equals(other.user_idx))
			return false;
		return true;
	}
	
}
