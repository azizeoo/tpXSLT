<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Type du document : HTML -->
	<xsl:output method="html" indent="yes" />

	<!-- Template principal du document -->
	<xsl:template match="/">
		<html>
			<body>
				<h1>Ticket de caisse (ligne par ligne)</h1>
				<xsl:apply-templates select="ticketDeCaisse/articles/article" />
			</body>
		</html>
	</xsl:template>

	<!-- Template pour la balise "article" -->
	<xsl:template match="article">
		<p>
			<xsl:value-of select="libelle" />
		</p>
	</xsl:template>

</xsl:stylesheet>