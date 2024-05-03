<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Employee Status</title>
        <style>
          .part-time {
            background-color: #ffcccb; 
          }
        </style>
      </head>
      <body>
        <h2>Employee Status</h2>
        <table border="2">
          <tr>
            <th>Name</th>
            <th>Status</th>
          </tr>
          <xsl:apply-templates select="employees/employee"/>
        </table>
      </body>
    </html>
  </xsl:template>
  
  <xsl:template match="employee">
    <tr>
      <td><xsl:value-of select="name"/></td>
      <xsl:variable name="status" select="status"/>
      <xsl:choose>
        <xsl:when test="$status='part-time'">
          <td class="part-time"><xsl:value-of select="$status"/></td>
        </xsl:when>
        <xsl:otherwise>
          <td><xsl:value-of select="$status"/></td>
        </xsl:otherwise>
      </xsl:choose>
    </tr>
  </xsl:template>
</xsl:stylesheet>
