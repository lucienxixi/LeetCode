SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerMA](
	[CustomerID] [int] NOT NULL,
	[CustomerName] [nvarchar](25) NULL,
	[CustomerAddress] [varchar](20) NULL,
	[CustomerCity] [varchar](20) NULL,
	[CustomerState] [char](2) NULL,
	[CustomerPostalCode] [varchar](9) NULL,
	[CustomerType] [varchar](20) NULL
 CONSTRAINT [Customer_PK1] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
)
GO

