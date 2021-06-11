package com.peterweckend.dotdashpweckendrestservice;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

@Service
public class SearchBooksService {
    // In a real world application, I would put these in their
    // own file or create an Enum for them
    public static final String URL_PARAM_KEY = "key";
    public static final String URL_PARAM_QUERY = "q";
    public static final String URL_PARAM_PAGE = "page";
    public static final String URL_PARAM_FIELD = "search[field]";

    public static final String AUTHOR_FIELD = "author";
    public static final String TITLE_FIELD = "title";

    public static final String BOOK_TAG = "best_book";
    public static final String AUTHOR_TAG = "author";
    public static final String AUTHOR_NAME_TAG = "name";
    public static final String TITLE_TAG = "title";
    public static final String IMAGE_TAG = "image_url";

    @Value("${api.key}")
    private String apiKey;
    @Value("${api.searchBooks.url}")
    private String url;

    public ArrayList<BookModel> SearchGoodReadsForBooksByTerms(String searchTerms, String field, Integer pageNumber) throws ParserConfigurationException, IOException, URISyntaxException, SAXException {
        // For a larger app, I might have a validator class I call here or in
        // the controller to check that required properties are supplied and
        // and the provided values are in the correct format
        URIBuilder uriBuilder = new URIBuilder(url);
        uriBuilder.addParameter(URL_PARAM_KEY, apiKey);
        uriBuilder.addParameter(URL_PARAM_QUERY, searchTerms);
        uriBuilder.addParameter(URL_PARAM_FIELD, field);
        uriBuilder.addParameter(URL_PARAM_PAGE, pageNumber.toString());

        // For a real world application, I would probably make a separate layer just for sending
        // queries to GoodReads and then handle the business logic of parsing the response here
        // in the service layer instead of doing it all in one file

        // For a real world application, I would do the due diligence to make sure there's
        // no risk of something like an XML injection attack

        // I would also look improve performance by caching the results from GoodReads, and
        // finding ways to optimize the XML parsing (using either another library or finding
        // ways to optimize this current library)

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
                var authorName = bookElement.getElementsByTagName(AUTHOR_NAME_TAG).item(0).getTextContent();
                var title = bookElement.getElementsByTagName(TITLE_TAG).item(0).getTextContent();
                var imageUrl = bookElement.getElementsByTagName(IMAGE_TAG).item(0).getTextContent();

                books.add(new BookModel(authorName, title, imageUrl));
            }
        }

        return books;
    }
}
