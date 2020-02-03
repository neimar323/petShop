package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteRowMapper implements RowMapper<Cliente> {

    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente c = new Cliente();
        c.setId(rs.getLong("id"));
        c.setCpf(rs.getString("cpf"));
        c.setNome(rs.getString("nome"));
        if(rs.getDate("nascimento") != null){
            c.setNascimento(rs.getDate("nascimento").toLocalDate());
        }
        return c;
    }
}
