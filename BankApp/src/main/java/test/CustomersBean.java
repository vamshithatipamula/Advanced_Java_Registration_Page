package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomersBean implements Serializable
{
	private String username, password, name, address,accountNumber;
	private Long phoneNumber, balance;
	private Integer pinNumber;
	public CustomersBean() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Integer getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(Integer pinNumber) {
		this.pinNumber = pinNumber;
	}
}
