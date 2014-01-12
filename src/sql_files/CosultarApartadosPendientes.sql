SELECT F.idFactura, FP.Saldo,FP.FechaVencimiento,F.TotalFacturado,F.idCliente
FROM Factura AS F,FacturasPendientes AS FP
WHERE FP.Saldo <>0;
