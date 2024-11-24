package com.example.actividad_de_titulo;

public class Motor {
    private String kw;
    private String marca;
    private String tipo;
    private String a220;
    private String rpm;
    private String nr;
    private String paso;
    private String vBob;
    private String diametroAlambre;
    private String conex;
    private String d;
    private String d2;
    private String l;
    private String pr;
    private String pCuK;
    private String lBob;
    private String muF;

    public Motor() {} // Constructor vacío requerido para Firestore

    public Motor(String kw, String marca, String tipo, String a220, String rpm, String nr, String paso,
                 String vBob, String diametroAlambre, String conex, String d, String d2, String l,
                 String pr, String pCuK, String lBob, String muF) {
        this.kw = kw;
        this.marca = marca;
        this.tipo = tipo;
        this.a220 = a220;
        this.rpm = rpm;
        this.nr = nr;
        this.paso = paso;
        this.vBob = vBob;
        this.diametroAlambre = diametroAlambre;
        this.conex = conex;
        this.d = d;
        this.d2 = d2;
        this.l = l;
        this.pr = pr;
        this.pCuK = pCuK;
        this.lBob = lBob;
        this.muF = muF;
    }

    // Getters
    public String getKw() { return kw; }
    public String getMarca() { return marca; }
    public String getTipo() { return tipo; }
    public String getA220() { return a220; }
    public String getRpm() { return rpm; }
    public String getNr() { return nr; }
    public String getPaso() { return paso; }
    public String getVBob() { return vBob; }
    public String getDiametroAlambre() { return diametroAlambre; }
    public String getConex() { return conex; }
    public String getD() { return d; }
    public String getD2() { return d2; }
    public String getL() { return l; }
    public String getPr() { return pr; }
    public String getPCuK() { return pCuK; }
    public String getLBob() { return lBob; }
    public String getMuF() { return muF; }
}

