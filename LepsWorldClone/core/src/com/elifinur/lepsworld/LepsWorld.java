package com.elifinur.lepsworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LepsWorld extends Game {

    int temp = 0;
    int temp2 = 8;
    int temp3 = 0;

    int altinKirmaKontrol = 1;
    Random random;
    float randomDegisken;

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;

    Texture arkaPlan;
    Texture arkaPlan2;
    Texture arkaPlan3;
    Texture arkaPlan4;
    Texture leps;
    Texture leps2;
    Texture leps3;
    Texture leps4;
    Texture leps5;
    Texture dusman1;
    Texture dusman2;
    Texture ari;
    Texture ari2;
    Texture zemin;

    Texture blog;
    Texture blog2;
    Texture blog3;
    Texture blog4;

    Texture deniz;
    Texture altin;
    Texture extraCan;

    BitmapFont fontCan;
    BitmapFont fontGameOver;
    BitmapFont fontSkor;
    BitmapFont fontSure;
    BitmapFont fontSeviye;

    Circle[] dusman1Circle;
    Circle[] dusman2Circle;
    Circle[] extraCanCircle;
    Circle[] altinCircle;

    Rectangle lepsRectangle;
    Rectangle[] ariRectangle;
    Rectangle[] blogRectangle;
    Rectangle[] blog2Rectangle;
    Rectangle[] blog3Rectangle;
    Rectangle[] blog4Rectangle;
    Rectangle[] denizRectangle;

    float ariWidth = 0;
    float ariHeight = 0;
    float altinWidth = 0;
    float altinHeight = 0;
    float extraCanWidth = 0;
    float extraCanHeight = 0;
    float lepsHeight = 0;
    float lepsWidth = 0;
    float dusmanHeight = 0;
    float dusmanWidth = 0;
    float dusman2Width = 0;
    float dusman2Height = 0;
    float denizWidth = 0;
    float denizHeight = 0;
    float blogHeight = 0;
    float blogWidth = 0;

    float lepsX = 0;
    float lepsY = 0;
    float lepsZemin = 0;
    float dusmanZemin = 0;
    float dusman2Zemin = 0;
    float ariYükseklik = 0;
    float blogY1 = 0;
    float blogY2 = 0;

    float yerCekimi = 0.6f;

    float blogMesafe = 0;
    float denizMesafe = 0;
    float dusman1Mesafe = 0;
    float dusman2Mesafe = 0;
    float ariMesafe = 0;
    float extraCanMesafe = 0;
    float altinMesafe = 0;

    int lepsCan = 2;

    int oyununDurumu = 0;
    int tiklama = 3;
    int altinSkor = 0;
    int kontrol = 0;
    int kontrol2 = 0;
    int oyunSeviyesi = 1;
    int seviyeKontrol = 1;
    int lepsKontrol = 0;
    int denizKontrol = 0;
    int ariKontrol = 0;
    int kontrol3 = 0;
    int dusmanKontrol = 0;
    int dusmanKontrol2 = 0;
    int lepsDusmeKontrol = 1;
    int blogKontrol = 1;
    int blogKontrol2 = 1;
    int lepsDusmeKontrol2 = 1;
    int bloglarinGelmesi = 0;

    int blogSayisi = 1;
    int dusman1Sayisi = 1;
    int dusman2Sayisi = 1;
    int ariSayisi = 1;
    int denizSayisi = 1;
    int extraCanSayisi = 1;
    int altinSayisi = 2;

    float dusmeHizi;
    float blogHiz = 7;
    float dusman1Hiz = 7;
    float dusman2Hiz = 9;
    float ariHiz = 9;
    float denizHiz = 6;
    float altinHiz = 6;
    float extraCanHiz = 6;

    float blogX[] = new float[blogSayisi];
    float blogX2[] = new float[blogSayisi];
    float blogX3[] = new float[blogSayisi];
    float blogX4[] = new float[blogSayisi];

    float dusman1X[] = new float[dusman1Sayisi];
    float dusman2X[] = new float[dusman2Sayisi];
    float ariX[] = new float[ariSayisi];
    float denizX[] = new float[denizSayisi];
    float extraCanX[] = new float[extraCanSayisi];
    float altinX[] = new float[altinSayisi];

    float blogY[] = new float[blogSayisi];
    float blog2Y[] = new float[blogSayisi];
    float ariY[] = new float[ariSayisi];
    float dusman1Y[] = new float[dusman1Sayisi];
    float dusman2Y[] = new float[dusman2Sayisi];
    float extraCanY[] = new float[extraCanSayisi];
    float altinY[] = new float[altinSayisi];
    float denizY[] = new float[denizSayisi];

    Timer Timer = new Timer();
    int sure = 30;
    int sureKontrol = 1;
    int sureKontrol2 = 1;
    int sureKontrol3 = 1;

    TimerTask myTimerTask = new TimerTask() {
        @Override
        public void run() {
            sure--;
        }
    };

    public void startTimer() {
        Timer.schedule(myTimerTask, 0, 1000);
    }

    @Override
    //OYUN BAŞLADIĞINDA OLACAKLAR BURAYA YAZILIYOR
    public void create() {

        random = new Random();

        batch = new SpriteBatch();

        //RESİMLERİN ÇİZİLDİĞİ YER
        arkaPlan = new Texture("Background_1.png");
        arkaPlan2 = new Texture("Background_2.png");
        arkaPlan3 = new Texture("Background_3.png");
        arkaPlan4 = new Texture("Background_4.png");
        leps = new Texture("Leps1.png");
        leps2 = new Texture("Leps2.png");
        leps3 = new Texture("Leps3.png");
        leps4 = new Texture("Leps4.png");
        leps5 = new Texture("Leps5.png");
        dusman1 = new Texture("Enemies_Feind_1.png");
        dusman2 = new Texture("Enemies_Feind_2.png");
        ari = new Texture("ari.png");
        ari2 = new Texture("ari.png");
        zemin = new Texture("Stone.png");
        blog = new Texture("blog3.png");
        blog2 = new Texture("blog2.png");
        blog3 = new Texture("blog3.png");
        blog4 = new Texture("blog4.png");

        deniz = new Texture("Water.png");
        altin = new Texture("Coins.png");
        extraCan = new Texture("Pilz.png");

        //CİRCLE
        dusman1Circle = new Circle[dusman1Sayisi];
        dusman2Circle = new Circle[dusman2Sayisi];
        extraCanCircle = new Circle[extraCanSayisi];
        altinCircle = new Circle[altinSayisi];

        //RECTANGLE
        lepsRectangle = new Rectangle();
        ariRectangle = new Rectangle[ariSayisi];
        blogRectangle = new Rectangle[blogSayisi];
        blog2Rectangle = new Rectangle[blogSayisi];
        blog3Rectangle = new Rectangle[blogSayisi];
        blog4Rectangle = new Rectangle[blogSayisi];
        denizRectangle = new Rectangle[denizSayisi];

        //SHAPERENEDER
        shapeRenderer = new ShapeRenderer();

        //KORDİNATLAR
        lepsX = -150;
        lepsY = Gdx.graphics.getHeight() / 10;
        lepsZemin = Gdx.graphics.getHeight() / 10;
        dusmanZemin = Gdx.graphics.getHeight() / 13;
        dusman2Zemin = Gdx.graphics.getHeight() / 10f;
        ariYükseklik = Gdx.graphics.getHeight() / 2.1f;
        blogY1 = Gdx.graphics.getHeight() / 3.08f;
        blogY2 = Gdx.graphics.getHeight() / 1.68f;

        dusman1Mesafe = Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 10;
        dusman2Mesafe = Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 9;
        ariMesafe = Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 10;
        blogMesafe = Gdx.graphics.getWidth();
        denizMesafe = Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 5;
        altinMesafe = Gdx.graphics.getWidth() / 2;
        extraCanMesafe = Gdx.graphics.getWidth() + Gdx.graphics.getWidth() / 14;

        //BOYUNLANDIRMA
        lepsHeight = Gdx.graphics.getHeight() / 6;
        lepsWidth = Gdx.graphics.getWidth() / 12;
        dusmanHeight = Gdx.graphics.getHeight() / 14;
        dusmanWidth = Gdx.graphics.getWidth() / 15;

        dusman2Height = Gdx.graphics.getHeight() / 12;
        dusman2Width = Gdx.graphics.getWidth() / 13;

        ariWidth = Gdx.graphics.getWidth() / 12;
        ariHeight = Gdx.graphics.getHeight() / 10;
        extraCanWidth = Gdx.graphics.getWidth() / 14;
        extraCanHeight = Gdx.graphics.getHeight() / 12;
        altinWidth = Gdx.graphics.getWidth() / 12;
        altinHeight = Gdx.graphics.getHeight() / 10;
        denizWidth = Gdx.graphics.getWidth() / 5;
        denizHeight = Gdx.graphics.getHeight() / 9;
        blogHeight = Gdx.graphics.getHeight() / 15;
        blogWidth = Gdx.graphics.getWidth() / 13;

        fontCan = new BitmapFont();
        fontGameOver = new BitmapFont();
        fontSkor = new BitmapFont();
        fontSure = new BitmapFont();
        fontSeviye = new BitmapFont();

        fontCan.setColor(Color.WHITE);
        fontGameOver.setColor(Color.WHITE);
        fontSkor.setColor(Color.WHITE);
        fontSure.setColor(Color.WHITE);
        fontSeviye.setColor(Color.WHITE);

        fontCan.getData().setScale(4);
        fontGameOver.getData().setScale(8);
        fontSkor.getData().setScale(4);
        fontSure.getData().setScale(4);
        fontSeviye.getData().setScale(4);

        //BLOG
        for (int i = 0; i < blogSayisi; i++) {
            blogX[i] = (Gdx.graphics.getWidth()) + i * blogMesafe;
            blogX2[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 2;
            blogX3[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 3;
            blogX4[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 4;

            blogY[i] = blogY1;
            blog2Y[i] = blogY2;

            blogRectangle[i] = new Rectangle();
            blog2Rectangle[i] = new Rectangle();
            blog3Rectangle[i] = new Rectangle();
            blog4Rectangle[i] = new Rectangle();
        }

        //DUSMAN1
        for (int i = 0; i < dusman1Sayisi; i++) {
            dusman1X[i] = Gdx.graphics.getWidth() + i * dusman1Mesafe;
            dusman1Y[i] = dusmanZemin;
            dusman1Circle[i] = new Circle();
        }

        //DUSMAN2
        for (int i = 0; i < dusman2Sayisi; i++) {
            dusman2X[i] = Gdx.graphics.getWidth() + i * dusman2Mesafe;
            dusman2Y[i] = dusman2Zemin;
            dusman2Circle[i] = new Circle();
        }

        //ARI
        for (int i = 0; i < ariSayisi; i++) {
            ariX[i] = Gdx.graphics.getWidth() + i * ariMesafe;
            ariY[i] = ariYükseklik;
            ariRectangle[i] = new Rectangle();
        }

        //EXTRA CAN
        for (int i = 0; i < extraCanSayisi; i++) {
            extraCanX[i] = Gdx.graphics.getWidth() + i * extraCanMesafe;
            extraCanY[i] = -300;
            extraCanCircle[i] = new Circle();
        }

        //ALTIN
        for (int i = 0; i < altinSayisi; i++) {
            altinX[i] = Gdx.graphics.getWidth() + i * altinMesafe;
            for (int j = 0; j < altinSayisi; ) {
                randomDegisken = (random.nextFloat()) * Gdx.graphics.getHeight();
                randomDegisken = (random.nextFloat()) * Gdx.graphics.getHeight();
                if ((randomDegisken > (Gdx.graphics.getHeight() / 10) && randomDegisken < (Gdx.graphics.getHeight() / 4.32f)) ||
                        (randomDegisken < (Gdx.graphics.getHeight() / 1.35f) && randomDegisken > (Gdx.graphics.getHeight() / 1.54f)) ||
                        (randomDegisken > Gdx.graphics.getHeight() / 2.51f && randomDegisken < Gdx.graphics.getHeight() / 2)) {
                    altinY[i] = randomDegisken;
                    j++;
                }
            }
            altinCircle[i] = new Circle();
        }

        //DENİZ
        for (int i = 0; i < denizSayisi; i++) {
            denizX[i] = denizX[i] + denizSayisi * denizMesafe;
            denizRectangle[i] = new Rectangle();
            denizY[i] = 1;
        }
    }

    @Override
    //OYUN DEVAM ETTİKÇE OLACAKLAR
    public void render() {

        batch.begin();

        if (altinSkor >= 60 && seviyeKontrol == 1) {
            oyunSeviyesi = 2;
            sure += 40;
            seviyeKontrol++;
        }

        if (altinSkor >= 200 && seviyeKontrol == 2) {
            oyunSeviyesi = 3;
            sure += 20;
            seviyeKontrol++;
        }

        if (oyununDurumu == 0) {// OYUN BAŞLAMADI
            batch.draw(arkaPlan, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

            if (Gdx.input.justTouched()) {
                oyununDurumu = 1;
                tiklama = 3;
                sure = 100000;
                sureKontrol2 = 1;
            }

        } else if (oyununDurumu == 1) { // OYUN DEVAM EDİYOR

            if (!(sure == 31) && sureKontrol2 == 1) {
                sure = 31;
                sureKontrol2 = 0;
            }

            if (sureKontrol == 1) {
                startTimer();
                sureKontrol++;
            }

            sureKontrol3 = sure;
            if (lepsX < Gdx.graphics.getWidth() / 14.95) {
                lepsX += 4;

            } else {
                bloglarinGelmesi = 1;
            }

            if (oyunSeviyesi == 1) {
                batch.draw(arkaPlan2, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                batch.draw(zemin, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 9);
                if (dusmeHizi < 0) {
                    batch.draw(leps4, lepsX, lepsY, lepsWidth, lepsHeight);
                } else if (lepsY == Gdx.graphics.getHeight() / 1.514f || lepsY == lepsZemin || lepsY == Gdx.graphics.getHeight() / 2.58f) {
                    if (temp == 0) {
                        batch.draw(leps, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 0) {
                            temp = 1;
                            temp3 = 0;
                        } else {
                            temp2 -= 1;
                        }
                    } else if (temp == 1) {
                        batch.draw(leps2, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp3 == 0) {
                            if (temp2 == 8) {
                                temp = 2;
                            } else {
                                temp2 += 1;
                            }
                        } else {
                            if (temp2 == 8) {
                                temp = 0;
                            } else {
                                temp2 -= 1;
                            }
                        }
                    } else {
                        batch.draw(leps3, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 16) {
                            temp = 1;
                            temp3 = 1;
                        } else {
                            temp2 += 1;
                        }
                    }
                } else {
                    batch.draw(leps5, lepsX, lepsY, lepsWidth, lepsHeight);
                }

            } else if (oyunSeviyesi == 2) {
                batch.draw(arkaPlan3, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                batch.draw(zemin, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 9);
                if (dusmeHizi < 0) {
                    batch.draw(leps4, lepsX, lepsY, lepsWidth, lepsHeight);
                } else if (lepsY == Gdx.graphics.getHeight() / 1.514f || lepsY == lepsZemin || lepsY == Gdx.graphics.getHeight() / 2.58f) {
                    if (temp == 0) {
                        batch.draw(leps, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 0) {
                            temp = 1;
                            temp3 = 0;
                        } else {
                            temp2 -= 1;
                        }
                    } else if (temp == 1) {
                        batch.draw(leps2, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp3 == 0) {
                            if (temp2 == 8) {
                                temp = 2;
                            } else {
                                temp2 += 1;
                            }
                        } else {
                            if (temp2 == 8) {
                                temp = 0;
                            } else {
                                temp2 -= 1;
                            }
                        }
                    } else {
                        batch.draw(leps3, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 16) {
                            temp = 1;
                            temp3 = 1;
                        } else {
                            temp2 += 1;
                        }
                    }
                } else {
                    batch.draw(leps5, lepsX, lepsY, lepsWidth, lepsHeight);
                }

            } else {
                batch.draw(arkaPlan4, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                batch.draw(zemin, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() / 9);

                if (dusmeHizi < 0) {
                    batch.draw(leps4, lepsX, lepsY, lepsWidth, lepsHeight);
                } else if (lepsY == Gdx.graphics.getHeight() / 1.514f || lepsY == lepsZemin || lepsY == Gdx.graphics.getHeight() / 2.58f) {
                    if (temp == 0) {
                        batch.draw(leps, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 0) {
                            temp = 1;
                            temp3 = 0;
                        } else {
                            temp2 -= 1;
                        }
                    } else if (temp == 1) {
                        batch.draw(leps2, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp3 == 0) {
                            if (temp2 == 8) {
                                temp = 2;
                            } else {
                                temp2 += 1;
                            }
                        } else {
                            if (temp2 == 8) {
                                temp = 0;
                            } else {
                                temp2 -= 1;
                            }
                        }
                    } else {
                        batch.draw(leps3, lepsX, lepsY, lepsWidth, lepsHeight);
                        if (temp2 == 16) {
                            temp = 1;
                            temp3 = 1;
                        } else {
                            temp2 += 1;
                        }
                    }
                } else {
                    batch.draw(leps5, lepsX, lepsY, lepsWidth, lepsHeight);
                }

            }

            fontCan.draw(batch, "Can: " + String.valueOf(lepsCan), Gdx.graphics.getWidth() / 11, Gdx.graphics.getHeight() / 1.1f);
            fontSkor.draw(batch, "Puan: " + altinSkor, Gdx.graphics.getWidth() / 3f, Gdx.graphics.getHeight() / 1.1f);
            fontSeviye.draw(batch, "Seviye: " + oyunSeviyesi, Gdx.graphics.getWidth() / 1.8f, Gdx.graphics.getHeight() / 1.1f);
            fontSure.draw(batch, "Süre: " + sure, Gdx.graphics.getWidth() / 1.2f, Gdx.graphics.getHeight() / 1.1f);

            if (bloglarinGelmesi == 1) {

                //BLOG ÇİZİMİ
                for (int i = 0; i < blogSayisi; i++) {
                    if (blogX3[i] < -blogWidth * 3) {
                        blogX[i] = (Gdx.graphics.getWidth()) + i * blogMesafe;
                        blogX2[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 2;
                        blogX3[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 3;
                        blogY[i] = blogY1;

                    } else {
                        blogX[i] -= blogHiz;
                        blogX2[i] -= blogHiz;
                        blogX3[i] -= blogHiz;
                    }
                    batch.draw(blog, blogX[i], blogY[i], blogWidth * 2, blogHeight);
                    batch.draw(blog2, blogX2[i], blogY[i], blogWidth, blogHeight);
                    batch.draw(blog3, blogX3[i], blogY[i], blogWidth * 2, blogHeight);

                    blogRectangle[i] = new Rectangle(blogX[i], blogY[i], blogWidth * 2, blogHeight);
                    blog2Rectangle[i] = new Rectangle(blogX2[i], blogY[i], blogWidth, blogHeight);
                    blog3Rectangle[i] = new Rectangle(blogX3[i], blogY[i], blogWidth * 2, blogHeight);
                }

                //BLOG2 ÇİZİMİ
                for (int i = 0; i < blogSayisi; i++) {
                    if (blogX4[i] < -blogWidth * 5) {
                        blogX4[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 4;
                        blog2Y[i] = blogY2;
                    } else {
                        blogX4[i] -= blogHiz;
                    }

                    batch.draw(blog4, blogX4[i], blog2Y[i], blogWidth * 5, blogHeight);
                    blog4Rectangle[i] = new Rectangle(blogX4[i], blog2Y[i], blogWidth * 5, blogHeight);
                }

                //DENİZ ÇİZİMİ   //ARI ÇİZİMİ
                if (oyunSeviyesi > 1) {
                    //DENİZ ÇİZİMİ
                    if ((sure % 15) == 0) {
                        denizKontrol = 1;
                    }
                    for (int i = 0; i < denizSayisi; i++) {
                        if (denizX[i] < -denizWidth - 50) {
                            if (denizKontrol == 1)
                                denizX[i] = denizX[i] + denizSayisi * denizMesafe;
                        } else {
                            denizX[i] -= denizHiz;
                        }

                        batch.draw(deniz, denizX[i], 0, denizWidth, denizHeight);
                        denizRectangle[i] = new Rectangle(denizX[i] + 15, 1, denizWidth - 30, denizHeight);
                    }
                    denizKontrol = 0;

                    //ARI ÇİZİMİ
                    if ((sure % 7) == 0)
                        ariKontrol = 1;

                    for (int i = 0; i < ariSayisi; i++) {
                        if (ariX[i] < -ariWidth) {
                            if (ariKontrol == 1) {
                                ariX[i] += ariSayisi * ariMesafe;
                                ariY[i] = ariYükseklik;
                            }
                        } else {
                            ariX[i] -= ariHiz;
                        }
                        batch.draw(ari, ariX[i], ariY[i], ariWidth, ariHeight);
                        ariRectangle[i] = new Rectangle(ariX[i] + 10, ariY[i], ariWidth / 1.3f, ariHeight / 1.3f);
                    }
                    ariKontrol = 0;
                }

                //DUSMAN2 ÇİZİMİ
                if (oyunSeviyesi > 2) {
                    if ((sure % 9) == 0)
                        dusmanKontrol2 = 1;
                    for (int i = 0; i < dusman2Sayisi; i++) {
                        if (dusman2X[i] < -dusman2Width) {
                            if (dusmanKontrol2 == 1) {
                                dusman2X[i] += dusman2Sayisi * dusman2Mesafe;
                                dusman2Y[i] = dusman2Zemin;
                            }
                        } else {
                            dusman2X[i] -= dusman2Hiz;
                        }
                        batch.draw(dusman2, dusman2X[i], dusman2Y[i], dusman2Width, dusman2Height);
                        dusman2Circle[i] = new Circle(dusman2X[i] + dusman2Width / 2, (dusman2Y[i]) + dusman2Height / 2, dusman2Width / 3.5f);
                    }
                    dusmanKontrol2 = 0;
                }

                //DUSMAN ÇİZİMİ
                if ((sure % 4) == 0)
                    dusmanKontrol = 1;

                for (int i = 0; i < dusman1Sayisi; i++) {
                    if (dusman1X[i] < -dusmanWidth) {
                        if (dusmanKontrol == 1) {
                            dusman1X[i] += dusman1Sayisi * dusman1Mesafe;
                            dusman1Y[i] = dusmanZemin;
                        }

                    } else {
                        dusman1X[i] -= dusman1Hiz;
                    }
                    batch.draw(dusman1, dusman1X[i], dusman1Y[i] + 30, dusmanWidth, dusmanHeight);
                    dusman1Circle[i] = new Circle(dusman1X[i] + dusmanWidth / 2, (dusman1Y[i] + 30) + dusmanHeight / 2, dusmanWidth / 3.3f);
                }
                dusmanKontrol = 0;

                //EXTRA CAN ÇİZİMİ
                for (int i = 0; i < extraCanSayisi; i++) {
                    if (sure == 25 || sure == 10) {
                        extraCanX[i] = extraCanSayisi * extraCanMesafe;
                        extraCanY[i] = Gdx.graphics.getHeight() / 9;
                    }
                    extraCanX[i] -= extraCanHiz;

                    batch.draw(extraCan, extraCanX[i], extraCanY[i], extraCanWidth, extraCanHeight);
                    extraCanCircle[i] = new Circle(extraCanX[i] + extraCanWidth / 2, (extraCanY[i]) + extraCanHeight / 2, extraCanWidth / 3.3f);

                }

                //ALTIN ÇİZİMİ
                for (int i = 0; i < altinSayisi; i++) {
                    if (altinX[i] < -altinWidth) {
                        altinX[i] += altinSayisi * altinMesafe;
                        for (int j = 0; j < altinSayisi; ) {
                            randomDegisken = (random.nextFloat()) * Gdx.graphics.getHeight();
                            if ((randomDegisken > (Gdx.graphics.getHeight() / 10) && randomDegisken < (Gdx.graphics.getHeight() / 4.32f)) ||
                                    (randomDegisken < (Gdx.graphics.getHeight() / 1.35f) && randomDegisken > (Gdx.graphics.getHeight() / 1.54f)) ||
                                    (randomDegisken > Gdx.graphics.getHeight() / 2.51f && randomDegisken < Gdx.graphics.getHeight() / 2)) {
                                altinY[i] = randomDegisken;
                                j++;
                            }
                        }
                    } else {
                        altinX[i] -= altinHiz;
                    }
                    batch.draw(altin, altinX[i], altinY[i], altinWidth, altinHeight);
                    altinCircle[i] = new Circle(altinX[i] + altinWidth / 2, (altinY[i]) + altinHeight / 2, altinWidth / 3.5f);
                }
            }

            if (Gdx.input.justTouched() && tiklama == 0) {
                dusmeHizi = -20;
                tiklama++;
            } else if (Gdx.input.justTouched() && tiklama == 1) {
                dusmeHizi = -20;
                tiklama++;
            }
            if (lepsY >= lepsZemin || dusmeHizi < 0) {
                if (lepsKontrol == 0 && lepsDusmeKontrol == 1 && lepsDusmeKontrol2 == 1) {
                    dusmeHizi += yerCekimi;
                    lepsY -= dusmeHizi;
                }
            }
            if (lepsY <= lepsZemin && lepsKontrol == 0) {
                tiklama = 0;
                lepsY = lepsZemin;
            }

        } else if (oyununDurumu == 2) { // OYUN BİTTİ
            fontGameOver.draw(batch, "Oyun Bitti", Gdx.graphics.getWidth() / 2.8f, Gdx.graphics.getHeight() / 1.5f);
            fontCan.draw(batch, "Can: " + String.valueOf(lepsCan), Gdx.graphics.getWidth() / 11, Gdx.graphics.getHeight() / 1.1f);
            fontSkor.draw(batch, "Puan: " + altinSkor, Gdx.graphics.getWidth() / 3f, Gdx.graphics.getHeight() / 1.1f);
            fontSeviye.draw(batch, "Seviye: " + oyunSeviyesi, Gdx.graphics.getWidth() / 1.8f, Gdx.graphics.getHeight() / 1.1f);
            fontSure.draw(batch, "Süre: " + sureKontrol3, Gdx.graphics.getWidth() / 1.2f, Gdx.graphics.getHeight() / 1.1f);

            if (Gdx.input.justTouched()) {

                //BLOG
                for (int i = 0; i < blogSayisi; i++) {
                    blogX[i] = (Gdx.graphics.getWidth()) + i * blogMesafe;
                    blogX2[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 2;
                    blogX3[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 3;
                    blogX4[i] = (Gdx.graphics.getWidth() + i * blogMesafe) + blogWidth * 4;

                    blogY[i] = blogY1;
                    blog2Y[i] = blogY2;

                    blogRectangle[i] = new Rectangle();
                    blog2Rectangle[i] = new Rectangle();
                    blog3Rectangle[i] = new Rectangle();
                    blog4Rectangle[i] = new Rectangle();
                }

                //DUSMAN
                for (int i = 0; i < dusman1Sayisi; i++) {
                    dusman1X[i] = Gdx.graphics.getWidth() + i * dusman1Mesafe;
                    dusman1Y[i] = dusmanZemin;
                    dusman1Circle[i] = new Circle();
                }
                //DUSMAN2
                for (int i = 0; i < dusman2Sayisi; i++) {
                    dusman2X[i] = Gdx.graphics.getWidth() + i * dusman2Mesafe;
                    dusman2Y[i] = dusman2Zemin;
                    dusman2Circle[i] = new Circle();
                }

                //ARI
                for (int i = 0; i < ariSayisi; i++) {
                    ariX[i] = Gdx.graphics.getWidth() + i * ariMesafe;
                    ariY[i] = ariYükseklik;
                    ariRectangle[i] = new Rectangle();
                }

                //EXTRA CAN
                for (int i = 0; i < extraCanSayisi; i++) {
                    extraCanX[i] = Gdx.graphics.getWidth() + i * extraCanMesafe;
                    extraCanY[i] = -300;
                    extraCanCircle[i] = new Circle();
                }

                //ALTIN
                for (int i = 0; i < altinSayisi; i++) {
                    altinX[i] = Gdx.graphics.getWidth() + i * altinMesafe;
                    for (int j = 0; j < altinSayisi; ) {
                        randomDegisken = (random.nextFloat()) * Gdx.graphics.getHeight();
                        randomDegisken = (random.nextFloat()) * Gdx.graphics.getHeight();
                        if ((randomDegisken > (Gdx.graphics.getHeight() / 10) && randomDegisken < (Gdx.graphics.getHeight() / 4.32f)) ||
                                (randomDegisken < (Gdx.graphics.getHeight() / 1.35f) && randomDegisken > (Gdx.graphics.getHeight() / 1.54f)) ||
                                (randomDegisken > Gdx.graphics.getHeight() / 2.51f && randomDegisken < Gdx.graphics.getHeight() / 2)) {
                            altinY[i] = randomDegisken;
                            j++;
                        }
                    }
                    altinCircle[i] = new Circle();
                }

                //DENİZ
                for (int i = 0; i < denizSayisi; i++) {
                    denizX[i] = denizX[i] + denizSayisi * denizMesafe;
                    denizRectangle[i] = new Rectangle();
                    denizY[i] = 1;
                }
                lepsCan = 2;
                lepsX = -150;
                altinSkor = 0;
                bloglarinGelmesi = 0;
                oyunSeviyesi = 1;
                seviyeKontrol = 1;
                sure = 500000;
                lepsKontrol = 0;
                tiklama = 3;
                lepsY = lepsZemin;
                oyununDurumu = 0;
            }
        }

        batch.end();
        //  lepsCircle.set(lepsX + lepsWidth / 2, lepsY + lepsHeight / 2 - 5, lepsWidth / 4.6f);
        lepsRectangle.set(lepsX, lepsY, lepsWidth, lepsHeight);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);

        //  shapeRenderer.circle(lepsCircle.x, lepsCircle.y, lepsCircle.radius);
        // shapeRenderer.rect(lepsRectangle.x, lepsRectangle.y, lepsRectangle.width, lepsRectangle.height);

        //DÜŞMAN SHAPERENDERER
        for (int i = 0; i < dusman1Sayisi; i++) {
            //shapeRenderer.circle(dusman1Circle[i].x, dusman1Circle[i].y, dusman1Circle[i].radius);

            if (Intersector.overlaps(dusman1Circle[i], lepsRectangle)) {
                if (kontrol == 0) {
                    if (lepsY > lepsZemin) {
                        lepsCan++;
                        altinSkor += 5;
                        dusmeHizi = -10;
                        tiklama--;
                        if (seviyeKontrol > 1) {
                            altinSkor += 5;
                        }
                    }
                    if (seviyeKontrol > 1) {
                        if (altinSkor < 5) {
                            altinSkor = 0;
                        } else {
                            altinSkor -= 5;
                        }
                    }
                    lepsCan--;
                    kontrol++;
                    dusman1Y[i] = -333;
                }
                if (lepsCan == 0) {
                    kontrol++;
                    tiklama = 3;
                    oyununDurumu = 2;
                }
            }

            if (!Intersector.overlaps(dusman1Circle[i], lepsRectangle)) {
                kontrol = 0;
            }
        }
        //DÜŞMAN2 SHAPERENDERER
        for (int i = 0; i < dusman1Sayisi; i++) {
            //  shapeRenderer.circle(dusman2Circle[i].x, dusman2Circle[i].y, dusman2Circle[i].radius);

            if (Intersector.overlaps(dusman2Circle[i], lepsRectangle)) {
                if (kontrol3 == 0) {
                    if (seviyeKontrol > 1) {
                        if (altinSkor < 10) {
                            altinSkor = 0;
                        } else {
                            altinSkor -= 10;
                        }
                    }
                    lepsCan--;
                    kontrol3++;
                    dusman2Y[i] = -333;
                }
                if (lepsCan == 0) {
                    kontrol3++;
                    tiklama = 3;
                    oyununDurumu = 2;
                }
            }

            if (!Intersector.overlaps(dusman2Circle[i], lepsRectangle)) {
                kontrol3 = 0;
            }
        }

        //ARI SHAPERENDERER
        for (int i = 0; i < ariSayisi; i++) {

            // shapeRenderer.rect(ariRectangle[i].x, ariRectangle[i].y, ariRectangle[i].width, ariRectangle[i].height);

            if (Intersector.overlaps(ariRectangle[i], lepsRectangle)) {
                if (kontrol2 == 0) {
                    if (lepsY > ariYükseklik) {
                        lepsCan++;
                        altinSkor += 5;
                        dusmeHizi = -7;
                        tiklama = 1;

                        if (seviyeKontrol > 1) {
                            altinSkor += 5;
                        }
                    }
                    if (seviyeKontrol > 1) {
                        if (altinSkor < 5) {
                            altinSkor = 0;
                        } else {
                            altinSkor -= 5;
                        }
                    }
                    lepsCan--;
                    kontrol2++;
                    ariY[i] = -333;
                }
                if (lepsCan == 0) {
                    kontrol2++;
                    tiklama = 3;
                    oyununDurumu = 2;
                }
            }

            if (!Intersector.overlaps(ariRectangle[i], lepsRectangle)) {
                kontrol2 = 0;
            }
        }

        //ALTIN SHAPERENDERER
        for (int i = 0; i < altinSayisi; i++) {
            // shapeRenderer.circle(altinCircle[i].x, altinCircle[i].y, altinCircle[i].radius);

            if (Intersector.overlaps(altinCircle[i], lepsRectangle)) {
                altinSkor += 10;
                altinY[i] = -320;
            }

        }

        //DENİZ SHAPERENDERER
        for (int i = 0; i < denizSayisi; i++) {

            //  shapeRenderer.rect(denizRectangle[i].x, denizRectangle[i].y, denizRectangle[i].width, denizRectangle[i].height);

            if (Intersector.overlaps(denizRectangle[i], lepsRectangle)) {
                if (denizX[i] < lepsWidth / 1.26) {
                    if (denizX[i] < lepsWidth / 1.26) {

                        lepsKontrol = 1;
                        if (lepsY > -lepsHeight / 4f) {
                            lepsX -= 2;
                            lepsY -= 9;
                        } else {
                            lepsY = -500;
                            tiklama = 3;
                            oyununDurumu = 2;
                        }

                    }
                }
            }
            if (Intersector.overlaps(dusman1Circle[i], denizRectangle[i])) {
                dusman1Y[i] -= 7;
            }
            if (Intersector.overlaps(dusman2Circle[i], denizRectangle[i])) {
                dusman2Y[i] -= 9;
            }
            if (Intersector.overlaps(extraCanCircle[i], denizRectangle[i])) {
                extraCanY[i] -= 7;
            }
        }

        //EXTRA CAN SHAPERENDERER
        for (int i = 0; i < extraCanSayisi; i++) {
            //  shapeRenderer.circle(extraCanCircle[i].x, extraCanCircle[i].y, extraCanCircle[i].radius);

            if (Intersector.overlaps(extraCanCircle[i], lepsRectangle)) {
                if (seviyeKontrol > 2) {
                    if (altinSkor < 15) {
                        altinSkor = 0;
                    } else {
                        altinSkor -= 15;
                    }
                }
                extraCanY[i] = -300;
                if (lepsCan < 3) {
                    lepsCan++;
                }
            }

        }

        if (lepsY <= lepsZemin) {
            altinKirmaKontrol = 1;
        }

        //BLOG SHAPERENDERER
        for (int i = 0; i < blogSayisi; i++) {

//            shapeRenderer.rect(blogRectangle[i].x, blogRectangle[i].y, blogRectangle[i].width, blogRectangle[i].height);
//            shapeRenderer.rect(blog2Rectangle[i].x, blog2Rectangle[i].y, blog2Rectangle[i].width, blog2Rectangle[i].height);
//            shapeRenderer.rect(blog3Rectangle[i].x, blog3Rectangle[i].y, blog3Rectangle[i].width, blog3Rectangle[i].height);

            if (Intersector.overlaps(blogRectangle[i], lepsRectangle) || Intersector.overlaps(blog2Rectangle[i], lepsRectangle) || Intersector.overlaps(blog3Rectangle[i], lepsRectangle)) {

                if (Intersector.overlaps(blog2Rectangle[i], lepsRectangle) && !(lepsY >= Gdx.graphics.getHeight() / 2.78)) {
                    blogX2[i] = -213;
                    altinSkor += 10;
                }
                if (lepsY >= Gdx.graphics.getHeight() / 2.78) {//338
                    if (blogKontrol == 1) {
                        lepsY = Gdx.graphics.getHeight() / 2.58f;
                        lepsDusmeKontrol = 0;
                        blogKontrol = 0;
                        dusmeHizi = 0;
                        tiklama = 0;
                        //     tiklamaKontrol = 1;
                    }
                    if (Gdx.input.justTouched()) {
                        lepsDusmeKontrol = 1;
                    }
                } else if (blogKontrol == 1 && lepsY > lepsZemin && !(lepsY >= Gdx.graphics.getHeight() / 2.78)) {
                    lepsY = Gdx.graphics.getHeight() / 6.75f;
                    dusmeHizi = 1;
                    blogKontrol = 0;
                    tiklama = 2;
                }
            } else {
                blogKontrol = 1;
                lepsDusmeKontrol = 1;
            }
        }
        //BLOG2 SHAPERENDERER
        for (int i = 0; i < blogSayisi; i++) {
            //  shapeRenderer.rect(blog4Rectangle[i].x, blog4Rectangle[i].y, blog4Rectangle[i].width, blog4Rectangle[i].height);
            if (Intersector.overlaps(blog4Rectangle[i], lepsRectangle)) {

                if (lepsY >= Gdx.graphics.getHeight() / 1.71f) {//338
                    if (blogKontrol2 == 1) {
                        lepsY = Gdx.graphics.getHeight() / 1.514f;
                        lepsDusmeKontrol2 = 0;
                        blogKontrol2 = 0;
                        tiklama = 1;
                        dusmeHizi = 4;
                    }
                    if (Gdx.input.justTouched()) {
                        lepsDusmeKontrol2 = 1;
                    }
                } else if (blogKontrol2 == 1) {
                    lepsY = Gdx.graphics.getHeight() / 2.38f;
                    dusmeHizi = 1;
                    blogKontrol2 = 0;
                    altinKirmaKontrol = 0;
                }
            } else {
                blogKontrol2 = 1;
                lepsDusmeKontrol2 = 1;
            }
        }
        if (sure < 1) {
            tiklama = 3;
            oyununDurumu = 2;
            sureKontrol3 = 0;
        }
        shapeRenderer.end();
    }
}
