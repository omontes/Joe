SELECT SUM(F.`TotalTarjeta`+F.`TotalContado`) As TotalFacturado
FROM Factura AS F
WHERE  F.`Concepto`="Cancelada" AND F.`Estado`= "A" AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? ;
