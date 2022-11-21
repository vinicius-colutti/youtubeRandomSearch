package com.colutti.learningCucumber.cucumberSteps.features.youtube;

import com.colutti.learningCucumber.requests.RamdomWordRequest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubeRandomSearch {

    private WebDriver driver;

    private static final String YOUTUBE_ENDPOINT = "https://www.youtube.com/";

    private String ramdomWord;

    public YoutubeRandomSearch() {
        this.driver = new ChromeDriver();
        this.driver.get(YOUTUBE_ENDPOINT);
    }

    @Dado("que busca uma palavra aleatoria na API")
    public void searchRamdomWord() {
        this.ramdomWord = RamdomWordRequest.getRamdomWord();
    }

    @E("insere as informacoes na pesquisa do youtube")
    public void putWordOnSearchInput() {
        this.driver.findElement(By.id("search-input")).click();
        this.driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div[1]/div[1]/div/div[2]/input")).sendKeys(this.ramdomWord);
    }

    @Quando("executa a pesquisa")
    public void executeSearch() {
        this.driver.findElement(By.id("search-icon-legacy")).click();
    }

    @Entao("a pesquisa deve finalizar com sucesso")
    public void successOnSearch() {
        WebElement filterBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div[2]/div/ytd-section-list-renderer/div[1]/div[2]/ytd-search-sub-menu-renderer/div[1]/div/ytd-toggle-button-renderer/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")));
        filterBtn.click();
        this.driver.close();
    }

}
