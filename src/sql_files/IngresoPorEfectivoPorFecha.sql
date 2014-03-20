SELECT SUM(F.`TotalContado`)
FROM Factura AS F
WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`Estado` = "A"
GROUP BY F.idFactura;
