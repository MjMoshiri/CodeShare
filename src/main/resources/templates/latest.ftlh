<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link href="/css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/dracula.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list containers as container>
    <span id="load_date" style="color: darkblue">${container.getDate()}</span>
    <pre id="code_snippet"><code>${container.getCode()}</code></pre>
</#list>
</body>
</html>