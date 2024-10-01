package sh.com.pe.ExpenseManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import sh.com.pe.ExpenseManagement.configuration.TokenType;

/**
 *
 * @author shmen
 */
@Entity
@SequenceGenerator(name = "seq_generator_t", sequenceName = "TOKEN_SQC", initialValue = 1, allocationSize = 1)
@Table(name = "TOKEN")
public class Token {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_generator_t", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "token")
    private String token;

    @Column(name = "token_type")
    @Enumerated(EnumType.STRING)
    private TokenType token_type;

    @Column(name = "expired")
    private Integer expired;

    @Column(name = "revoked")
    private Integer revoked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarios")
    private Usuarios usuarios;

    public Token() {
    }

    public Token(int id, String token, TokenType token_type, Integer expired, Integer revoked, Usuarios usuarios) {
        this.id = id;
        this.token = token;
        this.token_type = token_type;
        this.expired = expired;
        this.revoked = revoked;
        this.usuarios = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getToken_type() {
        return token_type;
    }

    public void setToken_type(TokenType token_type) {
        this.token_type = token_type;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public Integer getRevoked() {
        return revoked;
    }

    public void setRevoked(Integer revoked) {
        this.revoked = revoked;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

}
