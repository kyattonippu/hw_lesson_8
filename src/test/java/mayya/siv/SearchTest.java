package mayya.siv;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

@Owner("kyattonippu")
@Feature("Parameterized Tests")
@Story("Search TV Series on MyShows")
public class SearchTest {

    private final SearchTestSteps steps = new SearchTestSteps();
    //1
    @ValueSource(strings = {"Ведьмак", "Декстер"})
    @Tag("1")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search TV Series with ValueSource")
    @Link(name = "MyShows", url = "https://myshows.me/")
    @ParameterizedTest(name = "Displaying the series {0} in the search results")
    public void searchSeriesValueSourceTest(String searchQuery) {
        steps.openMyShows()
                .searchTvSeries(searchQuery)
                .checkTvSeries(searchQuery);
    }
    //2
    @CsvSource(value = {
            "Ведьмак",
            "Декстер"
    })

    @Tag("2")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search TV Series with CsvSource")
    @Link(name = "MyShows", url = "https://myshows.me/")
    @ParameterizedTest(name = "Displaying the series {0} in the search results")
    public void searchSeriesCsvSourceTest(String searchQuery) {
        steps.openMyShows()
                .searchTvSeries(searchQuery)
                .checkTvSeries(searchQuery);
    }

    @EnumSource(SeriesNames.class)
    @Tag("3")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search TV Series with EnumSource")
    @Link(name = "MyShows", url = "https://myshows.me/")
    @ParameterizedTest(name = "Displaying the series {0} in the search results")
    public void searchSeriesEnumSourceTest(SeriesNames seriesNames) {
        steps.openMyShows()
                .searchTvSeries(seriesNames.getName())
                .checkTvSeries(seriesNames.getName());
    }

    @MethodSource("searchSeriesMethodSourceTest")
    @Tag("4")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Search TV Series with MethodSource")
    @Link(name = "MyShows", url = "https://myshows.me/")
    @ParameterizedTest(name = "Displaying the series {0} in the search results")
    public void searchSeriesMethodSourceTest(String searchQuery) {
        steps.openMyShows()
                .searchTvSeries(searchQuery)
                .checkTvSeries(searchQuery);
    }

    static Stream<Arguments> searchSeriesMethodSourceTest() {
        return Stream.of(
                Arguments.of("Ведьмак"),
                Arguments.of("Декстер"));
    }
}
