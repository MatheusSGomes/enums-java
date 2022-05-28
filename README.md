# Enums com Java

Usado quando precisamos representar *constantes* e valores fixos.

Um exemplo disso está quando usamos uma `Thread`.

`Thread` é uma linha de execução. Podemos ter várias linhas de execução.

Podemos dizer que uma linha é mais importante ou tem mais preferência do que a outra através do método `setPriority()` que recebe um inteiro.

Ou seja, podemos dizer que uma linha de código que tem a prioridade 1 é menos importante do que a que tem prioridade 5, que e menos importante do que a que tem prioridade 10.

No `Thread` podemos usar númeos inteiros:

```java
public class TesteEnums {

    public static void main(String[] args) {
        Thread t = new Thread(() ->  System.out.println("Rodando..."));

        t.setPriority(10);
        t.start(); 
    }
}

// Rodando...
```

O recomendável não é usar um número inteiro, já que temos como passar valores pre-definidos.

Enums existem para definir constantes, ou seja, valores pré-definidos.

```java
public class TesteEnums {
    public static void main(String[] args) {
        System.out.println(Thread.MAX_PRIORITY);    // 10
        System.out.println(Thread.MIN_PRIORITY);    // 1
        System.out.println(Thread.NORM_PRIORITY);    // 5
    }
}
```

Ao invés de implementar com Enums, implementamos com inteiros:

```java
public class TesteEnums {
    public static void main(String[] args) {
        Thread t = new Thread(() ->  System.out.println("Rodando..."));

        t.setPriority(Thread.MAX_PRIORITY);
        t.start(); // Rodando...
    }
}
```

---

ATALHO DO ELCIPSE:

Quando criamos uma classe com `new` > `Class`, logo abaixo podemos criar um `Enum`.

---

Criado o `enum`:

```java
public enum Prioridade {}
```

Definimos os valores para essa enumeração:

```java
public enum Prioridade {

    MIN, NORMAL, MAX;

}
```

Para usar essa prioridade, declaramos ela como um tipo de referência e o nome da variável.

Não se instancia uma enumeração com `new Prioridade()`. É uma "classe com construtor privado".

`MIN`, `MAX` e `NORMAL` são como instancias da classe Prioridade que automaticamente estão sendo criadas por mim:

```java
Prioridade pMin = Prioridade.MIN;
```

A apartir daqui podemos interagir com essa enumeração usando alguns métodos que são herdados da classe `Object` e da classe `Enum`:

```java
public class TestePrioridade {

    public static void main(String[] args) {

        Prioridade pMin = Prioridade.MIN;
        Prioridade pMax = Prioridade.MAX;

        System.out.println(pMin.name());    // MIN
        System.out.println(pMax.name());    // MAX

        System.out.println(pMin.ordinal());    // 0
        System.out.println(pMax.ordinal());    // 2

    }

}
```

- O método `ordinal` cria uma ordem de acordo com a ordem de declaração. Como `MIN` foi declarado primeiro sua ordem é 0. Como `MAX` foi declarado em terceiro sua ordem é 2.

---

Enum também pode ter métodos. Eles compilam normalmente.

```java
public enum Prioridade {

    MIN, NORMAL, MAX;

    public String getNome() {
        return "Prioridade";
    }    
}
```

Podemos associar um valor aos objetos MIN, NORMAL e ao MAX:

```java
public enum Prioridade {

    MIN(1), NORMAL(5), MAX(10);

    private int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}
```

Por baixo dos panos, ao associar um valor a esses objetos ele está chamando o construtor, por isso precisamos passar o `int valor` nos parâmetros do construtor.

```java
public class TestePrioridade {

    public static void main(String[] args) {

        Prioridade pMin = Prioridade.MIN;
        Prioridade pMax = Prioridade.MAX;

        System.out.println(pMin.getValor()); // 1
        System.out.println(pMax.getValor()); // 10
    }
}
```

Muito útil para definir constantes e estados no código. Como um botão: ligado e desligado. Estações do ano (não mudam, são sempre as mesmas 4). Status de um pedido.
