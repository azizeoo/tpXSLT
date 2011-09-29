<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<!-- Type du document : HTML -->
	<xsl:output method="html" indent="yes" />

	<!-- Template principal du document -->
	<xsl:template match="/">
		<html>
			<body>
				<h1>Ticket de caisse (liste à puces)</h1>
				<xsl:apply-templates select="ticketDeCaisse/articles" />
			</body>
		</html>
	</xsl:template>

	<!-- Template pour la balise "articles" -->
	<xsl:template match="articles">
		<ul>
			<xsl:apply-templates select="article" />
		</ul>
	</xsl:template>

	<!-- Template pour la balise "article" -->
	<xsl:template match="article">
		<li>
			<xsl:value-of select="libelle" />
			<xsl:text> : </xsl:text>
			<xsl:value-of select="quantite" />
			<xsl:text> x </xsl:text>
			<xsl:value-of select="prixUnite" />
			<xsl:text>€</xsl:text>
		</li>
	</xsl:template>

</xsl:stylesheet>