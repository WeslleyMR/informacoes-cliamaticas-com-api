# 🌤️ Aplicação de Clima

Aplicação desktop desenvolvida em **JavaFX** para consultar informações meteorológicas de uma cidade utilizando a **WeatherAPI**.

## 📌 Sobre o projeto

O usuário informa o nome de uma cidade e a aplicação realiza uma consulta à API meteorológica, exibindo informações como:

* 🌡️ Temperatura atual
* ♨️ Sensação térmica
* ☁️ Condição do tempo
* 💧 Umidade
* 💨 Velocidade do vento
* 📊 Pressão atmosférica
* 📍 Cidade e país
* 🕐 Data e hora da última atualização

## ⚙️ Como executar

### 1. Clone o repositório

Clone o projeto utilizando:

```bash
git clone https://github.com/WeslleyMR/informacoes-cliamaticas-com-api.git
```
### 2. Crie uma conta na WeatherAPI

Para utilizar a aplicação, é necessário possuir uma **API Key** da WeatherAPI.

Acesse o site oficial:

https://www.weatherapi.com/

Depois:

1. Clique em **Sign Up**.
2. Crie sua conta.
3. Faça a confirmação da conta, caso seja solicitada.
4. Faça login.
5. Acesse o painel da sua conta.
6. Localize sua **API Key**.
7. Copie a chave.

### 3. Configure sua API Key

Dentro do projeto, crie o seguinte arquivo:

```text
src/main/resources/api/api.txt
```

Dentro do arquivo, coloque **somente sua API Key**:

```text
SUA_API_KEY
```

### 4. Execute o projeto

Abra o projeto e execute no Main principal.

## 🎯 Objetivo

Este projeto foi desenvolvido como prática de:

* Consumo de APIs REST
* Requisições HTTP em Java
* Manipulação de JSON
* Desenvolvimento de interfaces gráficas com JavaFX
* Organização de projetos Java com Maven
* Tratamento de erros
* Manipulação de arquivos e recursos

## 👨‍💻 Autor

**Weslley**

Projeto desenvolvido para estudos e prática de desenvolvimento Java.
