package com.javarush.test.level38.lesson06.home01;

/* Фабрика исключений
Создайте класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
Этот метод должен принимать один параметр - энум.
Если передан энум:
* ExceptionApplicationMessage, верните исключение Exception
* ExceptionDBMessage, верните исключение RuntimeException
* ExceptionUserMessage, верните Error
иначе верните IllegalArgumentException без сообщения.

В качестве сообщения (message) для каждого возвращаемого объекта используйте элементы энума, в которых все знаки
подчеркивания замените на пробелы. Сообщение должно быть в нижнем регистре за исключением первого символа.
Например, сообщение для ExceptionApplicationMessage.SOCKET_IS_CLOSED - "Socket is closed".

Верните класс созданной фабрики в методе Solution.getFactoryClass.

Энумы не меняйте.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(ExceptionFactory.getException(ExceptionApplicationMessage.SOCKET_IS_CLOSED));
        System.out.println(ExceptionFactory.getException(ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS));
        System.out.println(ExceptionFactory.getException(ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT));
        System.out.println(ExceptionFactory.getException(null));
    }

    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }
}
