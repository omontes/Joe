SELECT DISTINCT F.`idFactura`
FROM Factura AS F
WHERE F.`Concepto` = "Modificada" AND F.`Estado`="I";
