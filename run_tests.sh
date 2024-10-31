#!/bin/bash
# Script para execução dos testes da API agenda-coleta-lixo

echo "Iniciando a execução dos testes da API agenda-coleta-lixo..."

# Executar os testes com Maven
./mvnw clean test

# Verificar o status da execução
if [ $? -eq 0 ]; then
    echo "Testes concluídos com sucesso!"
else
    echo "Ocorreram falhas durante a execução dos testes."
fi
