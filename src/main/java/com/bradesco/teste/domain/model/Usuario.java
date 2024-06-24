package com.bradesco.teste.domain.model;

public record Usuario(String nome,
                      Integer idade) {

    @Override
    public String toString() {
        return "usuarioEntity{" +
                "  nome=" + nome +
                ", idade='" + idade +
                '}';
    }
}
