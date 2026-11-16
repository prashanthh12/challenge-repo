# How the Web Works — Request Lifecycle

**Flow:** URL → DNS → TCP → TLS (HTTPS) → HTTP request → HTTP response → Browser rendering

## 1. Entering a URL
When you type `https://example.com/products` and press Enter, the browser parses the **scheme** (`https`), **hostname** (`example.com`), and **path** (`/products`). It checks whether a suitable response is already cached and whether an existing connection can be reused.

## 2. DNS: Finding the Server
If the browser needs an IP address, it checks cached DNS records and uses a DNS resolver to find the hostname's **A (IPv4)** or **AAAA (IPv6)** record. DNS translates a human-readable domain into an IP address. The IP may point to a CDN or load balancer, not the origin server.

## 3. TCP: Creating a Connection
For HTTP/1.1 or HTTP/2 over TCP, the client establishes a connection to the server, usually port **443** for HTTPS, through the **three-way handshake**: `SYN → SYN-ACK → ACK`. TCP provides reliable, ordered delivery. A new handshake is unnecessary if an existing connection is reused.

## 4. TLS: Securing HTTPS
The browser and server perform a **TLS handshake**, agree on encryption keys, and the browser validates the server's certificate and hostname. Afterward, HTTP data travels encrypted. **Note:** HTTP/3 usually uses QUIC over UDP and integrates TLS 1.3 instead of a separate TCP handshake.

## 5. HTTP Request: Asking for a Resource
The browser sends a request such as:

```http
GET /products HTTP/1.1
Host: example.com
Accept: text/html
```

A request includes a **method** (`GET`, `POST`, etc.), target path, headers, and sometimes a body. Cookies or authorization headers may be included when applicable. The request may pass through a CDN, reverse proxy, and load balancer before an application server processes it, possibly querying a database or cache.

## 6. HTTP Response: Sending the Result
The server returns a **status code**, headers, and often a response body:

```http
HTTP/1.1 200 OK
Content-Type: text/html
Cache-Control: max-age=300

<html>...</html>
```

Common codes: **200** success, **301/302** redirect, **304** use cached content, **404** not found, **500** server error. Redirects trigger another request. Caching and compression can reduce transfer time.

## 7. Browser Rendering: Displaying the Page
The browser parses **HTML → DOM** and **CSS → CSSOM**, combines them into a render tree, calculates **layout**, then **paints** and **composites** pixels. JavaScript can modify the DOM/CSS and trigger further network requests or rendering work. Images, stylesheets, fonts, and scripts may be fetched separately. The page can become visible before every resource finishes loading.

## Interview-ready Answer (30–45 seconds)
“When I enter a URL, the browser parses it and checks relevant caches. If needed, DNS resolves the domain to an IP address. For typical HTTPS over HTTP/2, the browser establishes a TCP connection using a three-way handshake, then performs a TLS handshake to encrypt communication and verify the server. It sends an HTTP request, which may travel through a CDN or load balancer to the backend. The server returns a status code, headers, and content. Finally, the browser parses HTML and CSS, runs JavaScript, builds the page layout, and paints the result on screen. Additional resources may load in parallel. With HTTP/3, QUIC replaces TCP.”

**Remember:** DNS = *Where?* · TCP/QUIC = *How to connect?* · TLS = *How to secure it?* · HTTP = *What to request/return?* · Rendering = *How to display it?*
