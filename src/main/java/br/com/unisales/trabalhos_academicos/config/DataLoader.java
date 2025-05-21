package br.com.unisales.trabalhos_academicos.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.unisales.trabalhos_academicos.model.Aluno;
import br.com.unisales.trabalhos_academicos.model.TrabalhoAcademico;
import br.com.unisales.trabalhos_academicos.repository.AlunoRepository;
import br.com.unisales.trabalhos_academicos.repository.TrabalhoRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(AlunoRepository alunoRepository, TrabalhoRepository trabalhoRepository) {
        return args -> {
            Aluno Samuel = alunoRepository.save(new Aluno(null, "Samuel Duarte", "samuel@gmail.com", "123456"));
            Aluno Caio = alunoRepository.save(new Aluno(null, "Caio Silva", "caio@gmail.com", "123456"));
            Aluno Nicolas = alunoRepository.save(new Aluno(null, "Nicola Mendes", "nicolas@gmail.com", "123456"));
            Aluno Diego = alunoRepository.save(new Aluno(null, "Diego Rocha", "diego@gmail.com", "123456"));
            Aluno Luiz = alunoRepository.save(new Aluno(null, "Luiz Souza", "luiz@gmail.com", "123456"));

            trabalhoRepository.saveAll(List.of(
                new TrabalhoAcademico(null, "Projeto Web", "Sistema de vendas online", LocalDate.of(2025, 6, 1), "Desenvolvimento Web", true, Samuel),
                new TrabalhoAcademico(null, "API REST", "API de produtos com autenticação", LocalDate.of(2025, 6, 30), "Back-end", false, Samuel),
                new TrabalhoAcademico(null, "Banco de Dados", "Modelagem de BD relacional", LocalDate.of(2025, 6, 20), "Banco de Dados", true, Samuel),
                new TrabalhoAcademico(null, "Análise de Sistemas", "Documentação UML", LocalDate.of(2025, 7, 5), "Engenharia de Software", false, Samuel),
                new TrabalhoAcademico(null, "Front-end", "App com React", LocalDate.of(2025, 7, 25), "Interface Web", true, Samuel),

                new TrabalhoAcademico(null, "Algoritmos", "Problemas de lógica", LocalDate.of(2025, 6, 3), "Programação", true, Caio),
                new TrabalhoAcademico(null, "Estrutura de Dados", "Implementação de listas", LocalDate.of(2025, 6, 11), "Estrutura de Dados", false, Caio),
                new TrabalhoAcademico(null, "Desenvolvimento Ágil", "Scrum aplicado", LocalDate.of(2025, 6, 30), "Metodologias", true, Caio),
                new TrabalhoAcademico(null, "Rede de Computadores", "Simulação de rede", LocalDate.of(2025, 7, 2), "Redes", false, Caio),
                new TrabalhoAcademico(null, "Sistemas Operacionais", "Processos e threads", LocalDate.of(2025, 7, 20), "Sistemas", true, Caio),

                new TrabalhoAcademico(null, "Programação Orientada a Objetos", "Projeto com Java", LocalDate.of(2025, 6, 4), "POO", true, Nicolas),
                new TrabalhoAcademico(null, "Testes de Software", "JUnit aplicado", LocalDate.of(2025, 6, 12), "Qualidade", true, Nicolas),
                new TrabalhoAcademico(null, "DevOps", "Pipeline com GitHub Actions", LocalDate.of(2025, 6, 18), "DevOps", false, Nicolas),
                new TrabalhoAcademico(null, "Cloud Computing", "Deploy no Heroku", LocalDate.of(2025, 6, 28), "Infraestrutura", true, Nicolas),
                new TrabalhoAcademico(null, "Engenharia de Requisitos", "Levantamento e análise", LocalDate.of(2025, 7, 6), "Engenharia de Software", true, Nicolas),

                new TrabalhoAcademico(null, "Mobile", "App Flutter", LocalDate.of(2025, 6, 6), "Desenvolvimento Mobile", true, Diego),
                new TrabalhoAcademico(null, "IoT", "Monitoramento com sensores", LocalDate.of(2025, 6, 14), "Internet das Coisas", false, Diego),
                new TrabalhoAcademico(null, "Inteligência Artificial", "Classificação de dados", LocalDate.of(2025, 6, 22), "IA", true, Diego),
                new TrabalhoAcademico(null, "Computação Gráfica", "Renderização 3D", LocalDate.of(2025, 6, 30), "Gráfica", false, Diego),
                new TrabalhoAcademico(null, "Realidade Aumentada", "AR com Unity", LocalDate.of(2025, 7, 8), "RA", true, Diego),

                new TrabalhoAcademico(null, "Segurança da Informação", "Criptografia básica", LocalDate.of(2025, 6, 7), "Segurança", true, Luiz),
                new TrabalhoAcademico(null, "Big Data", "Hadoop e Spark", LocalDate.of(2025, 6, 15), "Dados", true, Luiz),
                new TrabalhoAcademico(null, "Visualização de Dados", "Gráficos com D3.js", LocalDate.of(2025, 6, 23), "Visualização", true, Luiz),
                new TrabalhoAcademico(null, "Gestão de Projetos", "Plano de projeto", LocalDate.of(2025, 6, 30), "Gestão", false, Luiz),
                new TrabalhoAcademico(null, "Empreendedorismo", "Plano de negócio", LocalDate.of(2025, 7, 9), "Negócios", true, Luiz)
            ));
        };
    }
}
