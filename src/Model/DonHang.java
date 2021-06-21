package Model;

public class DonHang{

	private String MaDH;
	private int ID;
	private long TongTien;
	private String DiaChiNhan;
	private String sdt;
	private String tennguoimua;
	
	
	public DonHang() {}
	public DonHang(String maDH, int iD, long tongTien, String diachinhan){
		MaDH = maDH;
		ID = iD;
		TongTien = tongTien;
		DiaChiNhan=diachinhan;
		
	
	}
	
	
	
	public String getTennguoimua() {
		return tennguoimua;
	}
	public void setTennguoimua(String tennguoimua) {
		this.tennguoimua = tennguoimua;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMaDH() {
		return MaDH;
	}
	public void setMaDH(String maDH) {
		MaDH = maDH;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public long getTongTien() {
		return TongTien;
	}
	public void setTongTien(long tongTien) {
		TongTien = tongTien;
	}
	public String getDiaChiNhan() {
		return DiaChiNhan;
	}
	public void setDiaChiNhan(String diaChiNhan) {
		DiaChiNhan = diaChiNhan;
	}
	
	
	
}