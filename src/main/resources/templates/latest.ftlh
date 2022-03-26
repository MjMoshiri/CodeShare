<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest</title>
    <link href="/css/styles.css" rel="stylesheet"/>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list containers as container>
    <span id="load_date">
     ${container.getDate()}
</span>
    <pre id="code_snippet">
    ${container.getCode()}
</pre>
</#list>
</body>
</html>