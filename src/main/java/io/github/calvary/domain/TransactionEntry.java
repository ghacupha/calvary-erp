package io.github.calvary.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.github.calvary.domain.enumeration.TransactionEntryTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A TransactionEntry.
 */
@Entity
@Table(name = "transaction_entry")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "transactionentry")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TransactionEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "entry_amount", precision = 21, scale = 2)
    private BigDecimal entryAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_entry_type", nullable = false)
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Keyword)
    private TransactionEntryTypes transactionEntryType;

    @Column(name = "description")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Text)
    private String description;

    @Column(name = "was_proposed")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Boolean)
    private Boolean wasProposed;

    @Column(name = "was_posted")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Boolean)
    private Boolean wasPosted;

    @Column(name = "was_deleted")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Boolean)
    private Boolean wasDeleted;

    @Column(name = "was_approved")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Boolean)
    private Boolean wasApproved;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(
        value = { "parentAccount", "transactionAccountType", "transactionCurrency", "balanceSheetItemType" },
        allowSetters = true
    )
    private TransactionAccount transactionAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "transactionEntries" }, allowSetters = true)
    private AccountTransaction accountTransaction;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public TransactionEntry id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEntryAmount() {
        return this.entryAmount;
    }

    public TransactionEntry entryAmount(BigDecimal entryAmount) {
        this.setEntryAmount(entryAmount);
        return this;
    }

    public void setEntryAmount(BigDecimal entryAmount) {
        this.entryAmount = entryAmount;
    }

    public TransactionEntryTypes getTransactionEntryType() {
        return this.transactionEntryType;
    }

    public TransactionEntry transactionEntryType(TransactionEntryTypes transactionEntryType) {
        this.setTransactionEntryType(transactionEntryType);
        return this;
    }

    public void setTransactionEntryType(TransactionEntryTypes transactionEntryType) {
        this.transactionEntryType = transactionEntryType;
    }

    public String getDescription() {
        return this.description;
    }

    public TransactionEntry description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getWasProposed() {
        return this.wasProposed;
    }

    public TransactionEntry wasProposed(Boolean wasProposed) {
        this.setWasProposed(wasProposed);
        return this;
    }

    public void setWasProposed(Boolean wasProposed) {
        this.wasProposed = wasProposed;
    }

    public Boolean getWasPosted() {
        return this.wasPosted;
    }

    public TransactionEntry wasPosted(Boolean wasPosted) {
        this.setWasPosted(wasPosted);
        return this;
    }

    public void setWasPosted(Boolean wasPosted) {
        this.wasPosted = wasPosted;
    }

    public Boolean getWasDeleted() {
        return this.wasDeleted;
    }

    public TransactionEntry wasDeleted(Boolean wasDeleted) {
        this.setWasDeleted(wasDeleted);
        return this;
    }

    public void setWasDeleted(Boolean wasDeleted) {
        this.wasDeleted = wasDeleted;
    }

    public Boolean getWasApproved() {
        return this.wasApproved;
    }

    public TransactionEntry wasApproved(Boolean wasApproved) {
        this.setWasApproved(wasApproved);
        return this;
    }

    public void setWasApproved(Boolean wasApproved) {
        this.wasApproved = wasApproved;
    }

    public TransactionAccount getTransactionAccount() {
        return this.transactionAccount;
    }

    public void setTransactionAccount(TransactionAccount transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public TransactionEntry transactionAccount(TransactionAccount transactionAccount) {
        this.setTransactionAccount(transactionAccount);
        return this;
    }

    public AccountTransaction getAccountTransaction() {
        return this.accountTransaction;
    }

    public void setAccountTransaction(AccountTransaction accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    public TransactionEntry accountTransaction(AccountTransaction accountTransaction) {
        this.setAccountTransaction(accountTransaction);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TransactionEntry)) {
            return false;
        }
        return id != null && id.equals(((TransactionEntry) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TransactionEntry{" +
            "id=" + getId() +
            ", entryAmount=" + getEntryAmount() +
            ", transactionEntryType='" + getTransactionEntryType() + "'" +
            ", description='" + getDescription() + "'" +
            ", wasProposed='" + getWasProposed() + "'" +
            ", wasPosted='" + getWasPosted() + "'" +
            ", wasDeleted='" + getWasDeleted() + "'" +
            ", wasApproved='" + getWasApproved() + "'" +
            "}";
    }
}
