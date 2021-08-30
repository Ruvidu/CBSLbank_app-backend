package bank_management.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
@IdClass(Account_Key.class)
public class Account implements Serializable {

    @Id
    private long bankid;
    @Id
    private long personid;

    private long account_number;
    
    public Account() {
    }

	public Account(long bankid, long personid, long account_number) {
		super();
		this.bankid = bankid;
		this.personid = personid;
		this.account_number = account_number;
	}
    

    public long getBankid() {
		return bankid;
	}

	public void setBankid(long bankid) {
		this.bankid = bankid;
	}

	public long getPersonid() {
		return personid;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	

}