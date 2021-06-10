package com.peterweckend.dotdashpweckendrestservice;

import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.print.Book;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

@Service
public class SearchBooksService {
    // In a real world application, I would put these in their
    // own file or create an Enum for them
    public static final String URL_PARAM_KEY = "key";
    public static final String URL_PARAM_QUERY = "q";
    public static final String URL_PARAM_PAGE = "page";

    public static final String AUTHOR_SORT = "author";
    public static final String TITLE_SORT = "title";

    public static final String BOOK_TAG = "best_book";
    public static final String AUTHOR_TAG = "author";
    public static final String AUTHOR_NAME_TAG = "name";
    public static final String TITLE_TAG = "title";
    public static final String IMAGE_TAG = "image_url";

    @Value("${api.key}")
    private String apiKey;
    @Value("${api.searchBooks.url}")
    private String url;
    private static final Logger log = LoggerFactory.getLogger(SearchBooksService.class);

    public ArrayList<BookModel> SearchGoodReadsForBooksByTerms(String searchTerms, String sort, Integer pageNumber) {
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter(URL_PARAM_KEY, apiKey);
            uriBuilder.addParameter(URL_PARAM_QUERY, searchTerms);
            uriBuilder.addParameter(URL_PARAM_PAGE, pageNumber.toString());
            log.info("URI!" + uriBuilder.toString());

            // For a real world application, I would probably make a separate layer just for sending
            // queries to GoodReads and then handle the business logic of parsing the response here
            // in the service layer instead of doing it all in this file

            // For a real world application, I would do some checks to make sure there's
            // no security risks from the returned XML

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document bookSearchResults = documentBuilder.parse(new URL(uriBuilder.toString()).openStream());
            bookSearchResults.getDocumentElement().normalize();

            NodeList bookNodeList = bookSearchResults.getElementsByTagName(BOOK_TAG);

            var books = new ArrayList<BookModel>();
            for (int i = 0; i < bookNodeList.getLength(); i++) {
                Node bookNode = bookNodeList.item(i);

                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    var authorNode = bookElement.getElementsByTagName(AUTHOR_TAG).item(0);
                    Element authorElement = (Element) authorNode;
                    var authorName = authorElement.getElementsByTagName(AUTHOR_NAME_TAG).item(0).getTextContent();

                    var title = bookElement.getElementsByTagName(TITLE_TAG).item(0).getTextContent();
                    var imageUrl = bookElement.getElementsByTagName(IMAGE_TAG).item(0).getTextContent();

                    books.add(new BookModel(authorName, title, imageUrl));
                }
            }

            return books;
        } catch (Exception e) {
            log.error("An error occurred: " + e);
            return null;//"An error occurred";
        }
    }
}
