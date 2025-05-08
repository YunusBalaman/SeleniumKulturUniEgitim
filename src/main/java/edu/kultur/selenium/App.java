package edu.kultur.selenium;

/**
 * Hello world!
 *
 */
public class App 
{
    public void main()
    {
        System.out.println( "Hello World!" );
    }

    /**
     git clone projectUrl -> remotedan projeyi çeker
     git init -> projenin altında .git klasörü oluşturuyor. Git le alakalı her aksiyon buarada tutuluyor
     git remote add origin projectUrl  -> projenin adresiyle ilişkilinderiyor
     git add filename -> commit edilecek dosyaları belirlememizi sağlıyor   git add . bütün dosyaları ekler.
     (.gitignore da belirtilen dizinler haricinde)
     git status -> git add le eklenen ve eklenmeyen dosyaları gösterir
     git rm filename -> git add eklenen dosyayı eklenenler listesinden çıkartmayı sağlar
     git commit -m "message" -> remote atılacak dosyalsarı paket haline getirir.
     git push -u origin branchname -> commit i belirlenen remote adrese yollar
     git fetch origin -> branch lerdeki değişikleri bilgi olarak alır
     git pull origin branchname -> branchteki kod değişikleri getirir
     git merge branchname -> başka bir branchteki kod değişiklerini getirir
     git checkout branchname -> branch değiştirmemizi sağlar
     git switch branchname -> branch değiştirmeyi sağlar
     git branch branchname -> yeni branch oluşturur
     */
}
