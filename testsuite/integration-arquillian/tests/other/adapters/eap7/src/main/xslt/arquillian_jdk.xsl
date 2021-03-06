<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xalan="http://xml.apache.org/xalan"
                xmlns:a="http://jboss.org/schema/arquillian"
                version="2.0"
                exclude-result-prefixes="xalan a">

    <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes" xalan:indent-amount="4" standalone="no"/>
    <xsl:strip-space elements="*"/>

    <xsl:param name="javaHome"/>
        
    <xsl:template match="//*[local-name()='container' and @qualifier='app-server-eap7']/*[local-name()='configuration']">
        <xsl:copy>
            <xsl:apply-templates select="node()|@*"/>
            
                <property name="javaHome">
                    <xsl:value-of select="$javaHome"/>
                </property>
        </xsl:copy>
    </xsl:template>
    

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>
    

</xsl:stylesheet>