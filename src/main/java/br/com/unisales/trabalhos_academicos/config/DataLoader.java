package br.com.unisales.trabalhos_academicos.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;
import br.com.unisales.trabalhos_academicos.model.Universitario;
import br.com.unisales.trabalhos_academicos.repository.TrabalhoRepository;
import br.com.unisales.trabalhos_academicos.repository.UniversitarioRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(UniversitarioRepository universitarioRepository, TrabalhoRepository trabalhoRepository) {
        return args -> {
            Universitario samuel = universitarioRepository.save(new Universitario(null, "Samuel Duarte", "samuel@gmail.com", "123456"));
            Universitario caio = universitarioRepository.save(new Universitario(null, "Caio Silva", "caio@gmail.com", "123456"));
            Universitario nicolas = universitarioRepository.save(new Universitario(null, "Nicola Mendes", "nicolas@gmail.com", "123456"));
            Universitario diego = universitarioRepository.save(new Universitario(null, "Diego Rocha", "diego@gmail.com", "123456"));
            Universitario luiz = universitarioRepository.save(new Universitario(null, "Luiz Souza", "luiz@gmail.com", "123456"));

            trabalhoRepository.saveAll(List.of(
                new TrabalhoAcademico(null, "Projeto Web", "Sistema de vendas online", LocalDate.of(2025, 6, 1), "Desenvolvimento Web", true, samuel),
                new TrabalhoAcademico(null, "API REST", "API de produtos com autenticação", LocalDate.of(2025, 6, 30), "Back-end", false, samuel),
                new TrabalhoAcademico(null, "Banco de Dados", "Modelagem de BD relacional", LocalDate.of(2025, 6, 20), "Banco de Dados", true, samuel),
                new TrabalhoAcademico(null, "Análise de Sistemas", "Documentação UML", LocalDate.of(2025, 7, 5), "Engenharia de Software", false, samuel),
                new TrabalhoAcademico(null, "Front-end", "App com React", LocalDate.of(2025, 7, 25), "Interface Web", true, samuel),

                new TrabalhoAcademico(null, "Algoritmos", "Problemas de lógica", LocalDate.of(2025, 6, 3), "Programação", true, caio),
                new TrabalhoAcademico(null, "Estrutura de Dados", "Implementação de listas", LocalDate.of(2025, 6, 11), "Estrutura de Dados", false, caio),
                new TrabalhoAcademico(null, "Desenvolvimento Ágil", "Scrum aplicado", LocalDate.of(2025, 6, 30), "Metodologias", true, caio),
                new TrabalhoAcademico(null, "Rede de Computadores", "Simulação de rede", LocalDate.of(2025, 7, 2), "Redes", false, caio),
                new TrabalhoAcademico(null, "Sistemas Operacionais", "Processos e threads", LocalDate.of(2025, 7, 20), "Sistemas", true, caio),

                new TrabalhoAcademico(null, "Programação Orientada a Objetos", "Projeto com Java", LocalDate.of(2025, 6, 4), "POO", true, nicolas),
                new TrabalhoAcademico(null, "Testes de Software", "JUnit aplicado", LocalDate.of(2025, 6, 12), "Qualidade", true, nicolas),
                new TrabalhoAcademico(null, "DevOps", "Pipeline com GitHub Actions", LocalDate.of(2025, 6, 18), "DevOps", false, nicolas),
                new TrabalhoAcademico(null, "Cloud Computing", "Deploy no Heroku", LocalDate.of(2025, 6, 28), "Infraestrutura", true, nicolas),
                new TrabalhoAcademico(null, "Engenharia de Requisitos", "Levantamento e análise", LocalDate.of(2025, 7, 6), "Engenharia de Software", true, nicolas),

                new TrabalhoAcademico(null, "Mobile", "App Flutter", LocalDate.of(2025, 6, 6), "Desenvolvimento Mobile", true, diego),
                new TrabalhoAcademico(null, "IoT", "Monitoramento com sensores", LocalDate.of(2025, 6, 14), "Internet das Coisas", false, diego),
                new TrabalhoAcademico(null, "Inteligência Artificial", "Classificação de dados", LocalDate.of(2025, 6, 22), "IA", true, diego),
                new TrabalhoAcademico(null, "Computação Gráfica", "Renderização 3D", LocalDate.of(2025, 6, 30), "Gráfica", false, diego),
                new TrabalhoAcademico(null, "Realidade Aumentada", "AR com Unity", LocalDate.of(2025, 7, 8), "RA", true, diego),

                new TrabalhoAcademico(null, "Segurança da Informação", "Criptografia básica", LocalDate.of(2025, 6, 7), "Segurança", true, luiz),
                new TrabalhoAcademico(null, "Big Data", "Hadoop e Spark", LocalDate.of(2025, 6, 15), "Dados", true, luiz),
                new TrabalhoAcademico(null, "Visualização de Dados", "Gráficos com D3.js", LocalDate.of(2025, 6, 23), "Visualização", true, luiz),
                new TrabalhoAcademico(null, "Gestão de Projetos", "Plano de projeto", LocalDate.of(2025, 6, 30), "Gestão", false, luiz),
                new TrabalhoAcademico(null, "Empreendedorismo", "Plano de negócio", LocalDate.of(2025, 7, 9), "Negócios", true, luiz)
            ));
        };
    }
}
