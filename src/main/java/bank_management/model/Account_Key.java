package bank_management.model;

import java.io.Serializable;
import java.util.Objects;

public class Account_Key implements Serializable {

    private Long bankid;
    private String personid;

    public Account_Key() {
    }

  
    public Account_Key(Long bankid, String personid) {
		super();
		this.bankid = bankid;
		this.personid = personid;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account_Key accountkey = (Account_Key) o;
        return bankid.equals(accountkey.bankid) &&
                personid.equals(accountkey.personid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankid, personid);
    }
}