## :video_game: Sobre o projeto

Este projeto tem como objetivo recriar o jogo de número seis do curso de desenvolvimento de jogos da Danki Code, porém, seguindo boas práticas de programação, utilizando de SOLID.


## Importanto e configurando :gear:

Primeiro, clonamos nosso repositório:
```shell
# Clone o repositório
git clone https://github.com/FocaEnterprises/Game_06.git

# Navegue até a pasta do projeto
cd Game_06
```

### Importar na IntelliJ IDEA
Você pode importar diretamente a tela inicial, selecionando a opção "Get from Version Control" e colocando o link do repositório. Caso não queira fazer isso, basta seguir os seguintes passos:

- Na tela inicial, seleciona "Open or Import".
- Navegue até a pasta do repositório clonado.
- Selecione o arquivo "build.gradle" com um click duplo.
- Clique em "Open as project".
- Pronto!

### Build :hammer:
Se você estiver utilizando IntelliJ IDEA, não é necessário usar linhas de comando, pode compilar pela aba do Gradle dentro da IDE, consulte a [documentação](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html#run_terminal) caso não saiba fazer isso. Se prefira o terminal, fique a vontade.

No Windows:
```batch
gradlew build
```

No Linux:
```
./gradlew build
```
