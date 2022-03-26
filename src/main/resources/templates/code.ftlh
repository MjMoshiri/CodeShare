<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/dracula.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <meta charset="UTF-8">
    <title>Code</title>
    <link href="/css/styles.css" rel="stylesheet"/>
</head>
<body>
<span id="load_date">
    ${code.getDate()}
</span>
<pre id="code_snippet">
   <code class="java">${code.getCode()}</code>
</pre>
<#switch code.getSecret()>
    <#case "BOTH">
        <span id="time_restriction" style="color: black"> Remaining time in Second : ${code.getRemainingTime()} </span>
        <br>
        <span id="views_restriction"style="color: black"> Views left: ${code.getViews()} </span>
        <#break>
    <#case "TIME">
        <span id="time_restriction"style="color: black"> Remaining time in Second : ${code.getRemainingTime()} </span>
        <#break>
    <#case "VIEW">
        <span id="views_restriction"style="color: black"> Views left: ${code.getViews()} </span>
        <#break>
    <#default>
        <#break>
</#switch>

</body>
</html>