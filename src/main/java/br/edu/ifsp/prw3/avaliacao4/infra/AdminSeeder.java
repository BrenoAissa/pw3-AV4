package br.edu.ifsp.prw3.avaliacao4.infra;

import br.edu.ifsp.prw3.avaliacao4.usuario.Usuario;
import br.edu.ifsp.prw3.avaliacao4.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminSeeder implements CommandLineRunner {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            // Cria um usuário "admin" com senha "123456" (Criptografada!)
            var senhaCriptografada = passwordEncoder.encode("123456");
            var usuario = new Usuario(null, "admin", senhaCriptografada);
            repository.save(usuario);
            System.out.println("USUÁRIO ADMIN CRIADO COM SUCESSO!");
        }
    }
}