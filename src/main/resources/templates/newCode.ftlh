<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <link href="/css/styles.css" rel="stylesheet"/>
    <script src="/js/main.js" type="text/javascript"/>
    <script></script>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<form>
    <textarea id="code_snippet" style="width: 300px; height: 150px;" placeholder="Your Code"></textarea>
    <br>
    <input id="time_restriction" placeholder="Time Restriction" type="text"/>
    <br>
    <input id="views_restriction" placeholder="Views Restriction" type="text"/>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
</body>
</html>