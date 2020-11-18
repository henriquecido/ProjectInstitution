Necessário alterar a tabela Trilha e Curso para que assim que o pai for deletado os filhos tambem sejam. 

Comando para ativação do Delete Cascade:


ALTER TABLE Trilha ADD CONSTRAINT `fk_Trilha_Funcionario1` FOREIGN KEY (`Funcionario_idFuncionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE CASCADE;

ALTER TABLE Curso ADD CONSTRAINT `fk_Curso_Trilha1` FOREIGN KEY (`Trilha_idTrilha`) REFERENCES `trilha` (`idTrilha`) ON DELETE CASCADE;