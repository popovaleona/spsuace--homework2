package ru.spsuace.homework2.objects;

import java.util.Objects;

/**
 * Опишите иммутабельное комплексное число, с геттерами и методами toString()
 * Так же дополните класс методами, чтобы эти объекты можно было использовать в HashMap
 * Плюс реализуйте любой метод (операцию) над комплексными числами (на ваш выбор)
 */
public class ComplexNumber {
    private final double real;
    private final double im;

    public ComplexNumber(double real, double im) {
        this.real = real;
        this.im = im;
    }

    public double getReal() {
        return real;
    }


    public double getIm() {
        return im;
    }


    @Override
    public String toString() {
        char sign;
        if (im > 0) {
            sign = '+';
        } else {
            sign = '-';
        }
        return " " + real + sign + Math.abs(im) + 'i';
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, im);
    }

    @Override
    public boolean equals(Object p) {
        if (p==null){
            return false;
        } else{
            ComplexNumber cn=(ComplexNumber)p;
            return (Math.abs(this.real-cn.real)==10e-5 && Math.abs(this.im- cn.im)==10e-5);
        }
    }
}
