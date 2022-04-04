package operatiiPePolinom;

public class Monom implements Cloneable {
    private Double coeficient;
    private Integer grad;

    public Monom(Double coeficient, Integer grad) {
        this.coeficient = coeficient;
        this.grad = grad;
    }

    public Monom() {
    }

    public Monom(Monom that) {
        this(that.getCoeficient(), that.getGrad());    //deepCopy

    }

    public Double getCoeficient() {
        return coeficient;
    }

    public Integer getGrad() {
        return grad;
    }

    public void setCoeficient(Double coeficient) {
        this.coeficient = coeficient;
    }

    public void setGrad(Integer grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {return coeficient + "x^" + grad;}
}
