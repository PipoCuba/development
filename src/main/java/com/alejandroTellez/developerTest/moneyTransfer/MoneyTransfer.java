package com.alejandroTellez.developerTest.moneyTransfer;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="money_transfer")
public class MoneyTransfer {
    @Id
    @Column(name = "transfer_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private  Long transferId;
    @Column(name = "from_account", nullable = false)
    private Long fromAccount;
    @Column(name = "to_account", nullable = false)
    private Long toAccount;
    @Column(name = "ammount", nullable = false)
    private Double ammount;
    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Long getToAccount() {
        return toAccount;
    }

    public void setToAccount(Long toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }


}
